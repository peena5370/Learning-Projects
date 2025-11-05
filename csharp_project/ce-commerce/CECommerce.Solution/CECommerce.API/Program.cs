using CECommerce.Module.Core.Services;
using CECommerce.Module.Order.Context;
using CECommerce.Module.Product.Context;
using CECommerce.Module.User.Context;
using CECommerce.Module.User.Filters;
using CECommerce.Module.User.Services;
using CECommerce.Utility.Configurations;
using CECommerce.Utility.Helpers;
using CECommerce.Utility.Logging;
using Microsoft.EntityFrameworkCore;
using Serilog;
using System.Diagnostics;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

// Bind Serilog from appsettings.json
Log.Logger = new LoggerConfiguration()
    .ReadFrom.Configuration(builder.Configuration)
    .Enrich.FromLogContext()
    .CreateLogger();

builder.Host.UseSerilog();

builder.Services.AddControllers();
// Learn more about configuring OpenAPI at https://aka.ms/aspnet/openapi
//builder.Services.AddOpenApi();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

// add environment settings dependency injection here
builder.Services.Configure<SnowflakeSettings>(builder.Configuration.GetSection("SnowflakeSettings"));

// Add db context for the module here
builder.Services.AddDbContext<OrderContext>(options => options.UseSqlServer(builder.Configuration.GetConnectionString("DbConnectionString")));
builder.Services.AddDbContext<ProductContext>(options => options.UseSqlServer(builder.Configuration.GetConnectionString("DbConnectionString")));
builder.Services.AddDbContext<UserContext>(options => options.UseSqlServer(builder.Configuration.GetConnectionString("DbConnectionString")));

// add dependency injection for service
builder.Services.AddScoped<ISystemService, SystemService>();
builder.Services.AddScoped<IUserService, UserService>();
builder.Services.AddScoped<IUserRoleService, UserRoleService>();

builder.Services.AddSingleton<ILogHelper, LogHelper>();
builder.Services.AddSingleton<ICacheHelper, CacheHelper>();

builder.Services.AddScoped<UserRoleFilter>();
// add caching
builder.Services.AddMemoryCache();

// use serilog logging
builder.Host.UseSerilog();

var app = builder.Build();

app.UseSerilogRequestLogging(); // Add Serilog request logging middleware

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    //app.MapOpenApi();
    app.UseSwagger();

    app.UseSwaggerUI(c =>
    {
        c.SwaggerEndpoint("/swagger/v1/swagger.json", "CECommerce API V1");
        c.RoutePrefix = "swagger"; // Set Swagger UI at the app's root
    });
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.MapFallback(() => Results.Text("no matching method found"));

app.Use(async (context, next) =>
{
    Debug.WriteLine($"Incoming request: {context.Request.Method} {context.Request.Path}");

    await next();
});

app.Run();
