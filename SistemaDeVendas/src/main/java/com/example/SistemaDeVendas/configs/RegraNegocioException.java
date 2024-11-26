package com.example.SistemaDeVendas.configs;

public class RegraNegocioException extends RuntimeException {


        // Construtor sem mensagem
        public RegraNegocioException() {
            super();
        }

        // Construtor com mensagem
        public RegraNegocioException(String message) {
            super(message);
        }

        // Construtor com mensagem e causa (exceção original)
        public RegraNegocioException(String message, Throwable cause) {
            super(message, cause);
        }

        // Construtor com a causa original
        public RegraNegocioException(Throwable cause) {
            super(cause);
        }
    }

