package com.ibjm.integraigreja.config;

import com.ibjm.integraigreja.domain.Igreja;
import com.ibjm.integraigreja.domain.Usuario;
import com.ibjm.integraigreja.domain.enums.Perfil;
import com.ibjm.integraigreja.domain.enums.StatusIgreja;
import com.ibjm.integraigreja.repositories.IgrejaRepository;
import com.ibjm.integraigreja.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instanciacao implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IgrejaRepository igrejaRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        igrejaRepository.deleteAll();

        Usuario Ivania = new Usuario(null, "Ivania Ramalho", "ivania.psi@gmail.com", "41999999999", "000.000.000.-01", "Ivania123@", Perfil.ADMINISTRADORGLOBAL);
        Usuario Edimar = new Usuario(null, "Edimar dos Santos Árcega", "edimar.eds@gmail.com", "4199707-5959", "000.000.000.-02", "Edimar123@", Perfil.ADMINISTRADORGLOBAL);
        Usuario Rocha = new Usuario(null, "Vinicius Rocha", "vrocha@gmail.com", "41999999999", "000.000.000.-03", "Rocha123@", Perfil.MEMBRO);
        userRepository.saveAll(Arrays.asList(Ivania, Edimar, Rocha));

        Igreja i1 = new Igreja(null, "Igreja Batista Jardim Maracana", "ibjm LTDA", "Batista", "52557860000124", "ibjm@gmail.com", "4199999999", "Rua Teste", 10, "83407-000", "Pastor Fulano", "Pastor Presidente", "000.000.000-00", "4199999999", StatusIgreja.ATIVO);
        igrejaRepository.saveAll(Arrays.asList(i1));

    }
}
