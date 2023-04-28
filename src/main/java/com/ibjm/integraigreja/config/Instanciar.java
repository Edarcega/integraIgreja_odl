package com.ibjm.integraigreja.config;

import com.ibjm.integraigreja.domain.Igreja;
import com.ibjm.integraigreja.domain.Membro;
import com.ibjm.integraigreja.domain.enums.StatusIgreja;
import com.ibjm.integraigreja.repositories.IgrejaRepository;
import com.ibjm.integraigreja.repositories.MembroRepository;
import com.ibjm.integraigreja.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instanciar implements CommandLineRunner {

    @Autowired
    IgrejaRepository igrejaRepository;

    @Autowired
    MembroRepository membroRepository;

    @Autowired
    EnderecoService enderecoService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Teste");

        Membro m1 = new Membro();
        Membro m2 = new Membro();
        m1.setNome("Edimar dos Santos Árcega");
        m2.setNome("Helen Esther Árcega");

        List<Membro> membros = new ArrayList<>();

        Igreja I1 = new Igreja(null,"Igreja Batista Jardim Maracanã","Ibjm LTDL","Batista","87173860000105",
                "ibjm@ibjm.com.br","41 3030-3030", enderecoService.findByCep("83405010"),"2039",
                "Anderson Castro","Pastor Titular","000.003.020-01","41 999999999", StatusIgreja.ATIVO,membroRepository.saveAll(Arrays.asList(m1,m2)));

        igrejaRepository.saveAll(Arrays.asList(I1));


    }
}
