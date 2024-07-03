<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Desafio Mi Calculadora</title>
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
	<main class="container">
		<h1>Calculadora</h1>
		<div class="grid">
			<form name="formulario" action="/DesafioMiCalculadora/Calculator"
				method="post">
				<div class="field">
					<input type="number" id="num1" name="num1" required
						pattern="\d+" title="Debe ser un número entero"
						placeholder="Número 1"
						value="${num1}">
				</div>
				<div class="field">
					<input type="number" id="num2" name="num2" required
						pattern="\d+" title="Debe ser un número entero"
						placeholder="Número 2"
						value="${num2}">
				</div>
				<div class="field">
					<select id="op" name="op" required>
						<option value="">Seleccione una operación</option>
						<option value="suma" ${op eq 'suma' ? 'selected' : ''}>Suma</option>
						<option value="resta" ${op eq 'resta' ? 'selected' : ''}>Resta</option>
						<option value="multiplicacion" ${op eq 'multiplicacion' ? 'selected' : ''}>Multiplicación</option>
						<option value="division" ${op eq 'division' ? 'selected' : ''}>División</option>
						<option value="ordenar" ${op eq 'ordenar' ? 'selected' : ''}>Ordenar el número.</option>
						<option value="paridad" ${op eq 'paridad' ? 'selected' : ''}>Cuál es par e impar.</option>
					</select>
				</div>
				<div class="field">
					<label for="resultado">Resultado: </label>
					<input type="text" id="resultado" name="resultado" readonly value="${resultado}">
				</div>				
				<div class="actions">
					<input type="submit" value="Calcular">
				</div>
			</form>
		</div>
	</main>
</body>
</html>