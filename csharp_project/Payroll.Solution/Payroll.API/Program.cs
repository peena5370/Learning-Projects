using Microsoft.EntityFrameworkCore;
using Payroll.Modules.HR.Context;
using Payroll.Modules.HR.Services;
using Serilog;

var builder = WebApplication.CreateBuilder(args);

// Bind Serilog from appsettings.json
Log.Logger = new LoggerConfiguration()
    .ReadFrom.Configuration(builder.Configuration)
    .Enrich.FromLogContext()
    .CreateLogger();

// Add services to the container.
builder.Services.AddControllers();

// Learn more about configuring OpenAPI at https://aka.ms/aspnet/openapi
builder.Services.AddOpenApi();

// Add db context for the module here
builder.Services.AddDbContext<EmployeeContext>(options => options.UseSqlServer(builder.Configuration.GetConnectionString("DbConnectionString")));

// add dependency injection for service
builder.Services.AddScoped<IEmployeeService, EmployeeService>();

// add caching
builder.Services.AddMemoryCache();

// use serilog logging
builder.Host.UseSerilog();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.MapFallback(() => Results.Text("no matching method found"));

app.Use(async (context, next) =>
{
    System.Diagnostics.Debug.WriteLine($"Incoming request: {context.Request.Method} {context.Request.Path}");

    await next();
});

app.Run();