package com.example.filip.agendavip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by filip on 05/12/2017.
 */

public class RepositorioContatos {
    private static List<Contato> contatos = new ArrayList<>();

    public static List<Contato> getContatos() { return contatos;}
}
