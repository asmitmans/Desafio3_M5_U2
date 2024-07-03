package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Calculator() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Leer los datos del formulario html
		String num1Str = request.getParameter("num1");
		String num2Str = request.getParameter("num2");
		String op = request.getParameter("op");
		
		// Validar que los 2 numeros son enteros 
		boolean esEntero1 = esEnteroValido(num1Str);
        boolean esEntero2 = esEnteroValido(num2Str);

        if (!esEntero1 || !esEntero2) {
        	response.sendRedirect("assets/html/error_nums.html");
        	return;
        }
        
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        
        // Validar si el segundo numero es cero
        if(num2 == 0 && op.equals("division")) {
        	response.sendRedirect("assets/html/error_div_cero.html");
        	return;
        }
        
        // Realizar los calculos
        String resultado = "";
        if(op.equals("suma")) {
        	resultado =  String.valueOf(num1 + num2);
        } else if (op.equals("resta")) {
        	resultado =  String.valueOf(num1 - num2);
        } else if (op.equals("multiplicacion")) {
        	resultado =  String.valueOf(num1 * num2);
        } else if (op.equals("division")) {
        	resultado =  String.valueOf(1.0*num1/num2);
        } else if (op.equals("ordenar")) {
        	if (num1 > num2) {
        		resultado = num1 + " es mayor que " + num2;
        	} else if (num2 > num1) {
        		resultado = num2 + " es mayor que " + num1;
        	} else {
        		resultado = "Los numeros son iguales";
        	}
        } else if (op.equals("paridad")) {
        	if ( esPar(num1) ) {
        		resultado += num1 + " es par";
        	} else { 
        		resultado += num1 + " es impar";
        	}
        	resultado += "; ";
        	if ( esPar(num2) ) {
        		resultado += num2 + " es par";
        	} else {
        		resultado += num2 + " es impar";
        	}
        }
        
        // Guardar el resultado en el request
        request.setAttribute("resultado", resultado);
        request.setAttribute("num1", num1Str); 
        request.setAttribute("num2", num2Str);
        request.setAttribute("op", op);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
  
	}
	
	private boolean esEnteroValido(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	private boolean esPar(int num) {
		return (num%2 == 0);
    }
	
	

}
