% La sintaxis es factorial(N, F) -> Factorial de N es F (el resultado se guarda en F)
factorial(0, 1).
factorial(1, 1).
factorial(N, F) :- N>0, N1 is N - 1, factorial(N1, F1), F is N * F1.

%el factorial se llama recursivamente dejando el resultado en F