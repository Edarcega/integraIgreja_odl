package com.ibjm.integraigreja.config;

import com.ibjm.integraigreja.domain.Grupo;
import com.ibjm.integraigreja.domain.Igreja;
import com.ibjm.integraigreja.domain.Membro;
import com.ibjm.integraigreja.domain.enums.EstadoCivil;
import com.ibjm.integraigreja.domain.enums.StatusIgreja;
import com.ibjm.integraigreja.repositories.*;
import com.ibjm.integraigreja.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
public class Instanciar implements CommandLineRunner {

    @Autowired
    IgrejaRepository igrejaRepository;

    @Autowired
    MembroRepository membroRepository;

    @Autowired
    EnderecoService enderecoService;

    @Autowired
    GrupoRepository grupoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FilhoRepository filhoRepository;

    @Override
    public void run(String... args) throws Exception {
//        userRepository.deleteAll();
//        filhoRepository.deleteAll();
//        membroRepository.deleteAll();
//        igrejaRepository.deleteAll();
//        grupoRepository.deleteAll();


//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date nascimento = sdf.parse("18/12/1986");
//        Date casamento = sdf.parse("22/09/2012");
//        Date date = new Date();
//        Pessoa conjuge = new Pessoa();
//        conjuge.setNome("Helen Esther");
//        Pessoa filho1 = new Pessoa();
//        Pessoa filho2 = new Pessoa();
//        Pessoa filho3 = new Pessoa();
//
//
//        Membro m1 = new Membro(null, "Edimar dos Santos Árcega", "009.881.109-00", "9064754-7", 'M', nascimento, "Brasileira",
//                enderecoService.findByCep("83407325"), "50", "Jose Julio", "Sirlei MArtins", "Analista de sistemas", EstadoCivil.CASADO, conjuge,
//                casamento, true, false, "n/a", Arrays.asList(filho1, filho2, filho3), new Date(), new Date(), true, "teste", null, null, null);

//        Membro m1 = new Membro(null, "Edimar dos Santos Árcega", "009.881.109-00", "9064754-7", 'M', sdf.parse("18/12/1986"), "Brasileira",
//                enderecoService.findByCep("83407325"), "50", "Jose Julio", "Sirlei MArtins", "Analista de sistemas", EstadoCivil.CASADO, null,
//                null, true, false, "n/a", null, new Date(), new Date(), true, "teste", null, null, null);
//
//
//        Membro m2 = new Membro();
//        m2.setNome("Helen Esther");
//        membroRepository.saveAll(Arrays.asList(m1, m2));
//
//
//        Grupo g1 = new Grupo();
//        g1.setNome("Resgate");
////        Grupo g1 = new Grupo(null, "Resgate", null, m1, m2, Arrays.asList(m1, m2));
//
//        Igreja I1 = new Igreja(null, "Igreja Batista Jardim Maracanã", "Ibjm LTDL", "Batista", "87173860000105",
//                "ibjm@ibjm.com.br", "41 3030-3030", enderecoService.findByCep("83405010"), "2039",
//                "Anderson Castro", "Pastor Titular", "000.003.020-01", "41 999999999", StatusIgreja.ATIVO, new ArrayList<>(), grupoRepository.saveAll(List.of(g1)), null, null);
//        I1.setGrupos(Arrays.asList(g1));
//        grupoRepository.saveAll(Arrays.asList(g1));
//        igrejaRepository.saveAll(Arrays.asList(I1));
//        I1.getMembros().addAll(Arrays.asList(m1, m2));
//        Igreja I2 = new Igreja();
//        igrejaRepository.saveAll(Arrays.asList(I1,I2));
    }
}
