using System.Data.SqlClient;
using System.Data;
using Microsoft.EntityFrameworkCore;
using Payroll.Modules.HR.Context;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllers();

// Learn more about configuring OpenAPI at https://aka.ms/aspnet/openapi
builder.Services.AddOpenApi();

// Add db context for the module here
builder.Services.AddDbContext<EmployeeContext>(options => options.UseSqlServer(builder.Configuration.GetConnectionString("DbConnectionString")));

builder.Logging.AddConsole();

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