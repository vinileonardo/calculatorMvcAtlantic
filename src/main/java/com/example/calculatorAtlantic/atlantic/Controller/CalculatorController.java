package com.example.calculatorAtlantic.atlantic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CalculatorController {

    // Método que recebe uma solicitação GET na raiz do servidor e retorna o nome do arquivo HTML a ser exibido
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Método que recebe uma solicitação POST na raiz do servidor e executa o cálculo solicitado pelo usuário
    @PostMapping("/")
    public String calculate(@RequestParam("num1") int num1, // Parâmetro que recebe o primeiro número
                            @RequestParam("num2") int num2, // Parâmetro que recebe o segundo número
                            @RequestParam("operation") String operation, // Parâmetro que recebe a operação a ser executada
                            Model model) { // Objeto Model que será usado para adicionar atributos à resposta
        int result; // Variável que armazenará o resultado do cálculo

        // Verifica qual operação deve ser executada e realiza o cálculo correspondente
        if(operation.equals("addition")) {
            result = num1 + num2; // Soma os dois números
        } else {
            result = num1 - num2; // Subtrai o segundo número do primeiro número
        }

        // Adiciona o resultado do cálculo ao objeto Model
        model.addAttribute("result", result);

        // Retorna o nome do arquivo HTML a ser exibido (neste caso, o mesmo arquivo "index" usado no método index())
        return "index";
    }
}