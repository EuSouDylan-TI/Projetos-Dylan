/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author f3l1p3
 */
public class TelaCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    
public TelaCadastro() {
    initComponents();
    carregarFotoPadrao();
    aplicarVisualModerno();
    configurarCadastro();
    carregarSexualidades();
    configurarMascaras();
    configurarEventoEnter();
}

   

private void configurarEventoEnter() {
    java.awt.Component[] campos = {
        jTextField1,
        jFormattedTextField1,
        jFormattedTextField3,
        jTextField3,
        jFormattedTextField2,
        jComboBox1,
        jFormattedTextField4,
        jTextField5,
        jTextField6,
        jTextField7,
        jTextField8,
        jTextField9,
        jTextField10,
        jComboBox2,
        CampoCurso,
        CampoEscolaridade,
        CampoEnsino,
        CampoCargoDesejado,
        Campointeresse,
        CampoProfissional,
        CampoTipo,
        jTextArea1,
        CampoLinkedin,
        CampoGit
    };

    for (java.awt.Component campo : campos) {
        if (campo instanceof javax.swing.JTextField) {
            ((javax.swing.JTextField) campo).addActionListener(e -> {
                if (campo == jFormattedTextField4) {
                    buscarCep();
                }

                campo.transferFocus();
            });

        } else if (campo instanceof javax.swing.JComboBox) {
            ((javax.swing.JComboBox<?>) campo).addActionListener(e -> {
                campo.transferFocus();
            });
        }
    }
}

    

private void configurarMascaras() {
    try {
        javax.swing.text.MaskFormatter cpf =
        new javax.swing.text.MaskFormatter("###.###.###-##");
        cpf.setPlaceholderCharacter('_');
        cpf.setAllowsInvalid(false);
        cpf.setValueContainsLiteralCharacters(false);

jFormattedTextField1.setFormatterFactory(
        new javax.swing.text.DefaultFormatterFactory(cpf)
);

        jFormattedTextField1.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(cpf)
        );

        javax.swing.text.MaskFormatter telefone =
        new javax.swing.text.MaskFormatter("(##) #####-####");
        telefone.setPlaceholderCharacter('_');
        telefone.setAllowsInvalid(false);
        telefone.setValueContainsLiteralCharacters(false);

jFormattedTextField2.setFormatterFactory(
        new javax.swing.text.DefaultFormatterFactory(telefone)
);

        javax.swing.text.MaskFormatter nascimento =
        new javax.swing.text.MaskFormatter("##/##/####");
        nascimento.setPlaceholderCharacter('_');
        nascimento.setAllowsInvalid(false);
        nascimento.setValueContainsLiteralCharacters(false);

jFormattedTextField3.setFormatterFactory(
        new javax.swing.text.DefaultFormatterFactory(nascimento)
);

        jFormattedTextField3.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(nascimento)
        );

        javax.swing.text.MaskFormatter cep =
                new javax.swing.text.MaskFormatter("#####-###");
        cep.setPlaceholderCharacter('_');
        cep.setValueContainsLiteralCharacters(true);
        cep.setAllowsInvalid(true);

        jFormattedTextField4.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(cep)
        );

    } catch (java.text.ParseException e) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Erro ao configurar as máscaras dos campos.",
                "Erro",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
}


    private void configurarCadastro() {

    CampoEscolaridade.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[]{
            "Selecione",
            "Ensino Técnico",
            "Ensino Superior",
            "Pós-graduação",
            "Mestrado",
            "Doutorado"
        }
    ));

    CampoProfissional.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[]{
            "Selecione",
            "Estágio",
            "Júnior",
            "Pleno",
            "Sênior",
            "Especialista"
        }
    ));

    CampoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[]{
            "Selecione",
            "Presencial",
            "Híbrido",
            "Remoto"
        }
    ));

    Campointeresse.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[]{
            "Selecione",
            "Desenvolvimento Front-end",
            "Desenvolvimento Back-end",
            "Full Stack",
            "Banco de Dados",
            "QA e Testes",
            "DevOps",
            "Cibersegurança",
            "Suporte de TI",
            "Inteligência Artificial"
        }
    ));

    
    jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[]{
            "UF", "AC", "AL", "AP", "AM", "BA", "CE", "DF",
            "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
            "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR",
            "SC", "SP", "SE", "TO"
        }
    ));

    jList2.setModel(new javax.swing.AbstractListModel<String>() {
        private final String[] linguagens = {
            "Java",
            "JavaScript",
            "Python",
            "C",
            "C++",
            "C#",
            "PHP",
            "SQL",
            "HTML",
            "CSS",
            "TypeScript"
        };

        @Override
        public int getSize() {
            return linguagens.length;
        }

        @Override
        public String getElementAt(int index) {
            return linguagens[index];
        }
    });


    jList2.setSelectionMode(
        javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
    );

    SalvaContinuarBotao.addActionListener(e -> salvarCadastro());

    CancelarBotao.addActionListener(e -> limparCadastro());

    AdicionarBotao.addActionListener(e -> adicionarLinguagens());

    SairBotao.addActionListener(e -> {
        int resposta = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Deseja sair da tela de cadastro?",
            "Sair",
            javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (resposta == javax.swing.JOptionPane.YES_OPTION) {
            dispose();
        }
    });

    InicioBotao.addActionListener(e ->
        javax.swing.JOptionPane.showMessageDialog(
            this, "Tela inicial do DevJobs."
        )
    );

    VagasBotao.addActionListener(e ->
        javax.swing.JOptionPane.showMessageDialog(
            this, "Área de vagas do DevJobs."
        )
    );

    MeuPerflBotao.addActionListener(e ->
        javax.swing.JOptionPane.showMessageDialog(
            this, "Você já está na tela de perfil."
        )
    );

        jFormattedTextField4.addFocusListener(
        new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                buscarCep();
            }
        }
    );
    
    }     
    
    

private void buscarCep() {
    String cep = jFormattedTextField4.getText()
            .replaceAll("\\D", "");

    if (cep.length() != 8) {
        return;
    }

    try {
        java.net.URL url = new java.net.URL(
                "https://viacep.com.br/ws/" + cep + "/json/"
        );

        java.net.HttpURLConnection conexao =
                (java.net.HttpURLConnection) url.openConnection();

        conexao.setRequestMethod("GET");
        conexao.setConnectTimeout(5000);
        conexao.setReadTimeout(5000);

        try {
            java.io.BufferedReader leitor =
                    new java.io.BufferedReader(
                            new java.io.InputStreamReader(
                                    conexao.getInputStream(),
                                    java.nio.charset.StandardCharsets.UTF_8
                            )
                    );

            StringBuilder resposta = new StringBuilder();
            String linha;

            try {
                while ((linha = leitor.readLine()) != null) {
                    resposta.append(linha);
                }
            } finally {
                leitor.close();
            }

            String json = resposta.toString();

            if (json.contains("\"erro\"")) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "CEP não encontrado.",
                        "Consulta de CEP",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            String rua = pegarValor(json, "logradouro");
            String bairro = pegarValor(json, "bairro");
            String cidade = pegarValor(json, "localidade");
            String uf = pegarValor(json, "uf");

            jTextField5.setText(rua);
            jTextField8.setText(bairro);
            jTextField9.setText(cidade);
            jComboBox2.setSelectedItem(uf);

        } finally {
            conexao.disconnect();
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Não foi possível consultar o CEP. Verifique sua conexão.",
                "Erro na consulta",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
}


    
       private String pegarValor(String json, String campo) {
           String busca = "\"" + campo + "\"";
                  int inicio = json.indexOf(busca);

    if (inicio == -1) {
        return "";
    }

    inicio = json.indexOf(":", inicio + busca.length());

    if (inicio == -1) {
        return "";
    }

    inicio = json.indexOf("\"", inicio);

    if (inicio == -1) {
        return "";
    }

    inicio++;

    int fim = json.indexOf("\"", inicio);

    if (fim == -1) {
        return "";
    }

    return json.substring(inicio, fim);
}


    


private void carregarSexualidades() {
    try {
        dao.SexualidadeDao sexualidadeDao = new dao.SexualidadeDao();      
        java.util.ArrayList<modelo.Sexualidade> lista = sexualidadeDao.consultarAtivas();
        javax.swing.DefaultComboBoxModel<modelo.Sexualidade> modeloCombo =
                new javax.swing.DefaultComboBoxModel<>();
        modelo.Sexualidade opcaoEscolher = new modelo.Sexualidade();
        opcaoEscolher.setId(0);
        opcaoEscolher.setDescricao("Escolher");     
        modeloCombo.addElement(opcaoEscolher);
        for (modelo.Sexualidade sexualidade : lista) {
            modeloCombo.addElement(sexualidade);
        }
        jComboBox1.setModel(modeloCombo);

    } catch (Exception e) {
        e.printStackTrace();

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Não foi possível carregar as opções de sexualidade.\n"
                + e.getMessage(),
                "Erro",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
}




    private void adicionarLinguagens() {

    java.util.List<String> selecionadas = jList2.getSelectedValuesList();

    if (selecionadas.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
            this,
            "Selecione pelo menos uma linguagem.",
            "Atenção",
            javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Linguagens selecionadas:\n" +
        String.join(", ", selecionadas),
        "Habilidades",
        javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
}
    private void carregarFotoPadrao() {
    java.net.URL caminho =
            getClass().getResource("/imagem/icone_usuario_512.png");

    if (caminho != null) {
        javax.swing.ImageIcon imagem =
                new javax.swing.ImageIcon(caminho);

        java.awt.Image redimensionada =
                imagem.getImage().getScaledInstance(
                        80, 80,
                        java.awt.Image.SCALE_SMOOTH
                );

        jLabel8.setText("");
        jLabel8.setIcon(
                new javax.swing.ImageIcon(redimensionada)
        );
        jLabel8.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );
        jLabel8.setVerticalAlignment(
                javax.swing.SwingConstants.CENTER
        );
    }
}
    
    private void salvarCadastro() {

    String nome = jTextField1.getText().trim();
    String cpf = jFormattedTextField1.getText().trim();
    String nascimento = jFormattedTextField3.getText().trim();
    String email = jTextField3.getText().trim();
    String senha = jTextField10.getText().trim();
    String telefone = jFormattedTextField2.getText().trim();
    modelo.Sexualidade sexualidadeSelecionada = (modelo.Sexualidade) jComboBox1.getSelectedItem();

    String cep = jFormattedTextField4.getText().trim();
    String logradouro = jTextField5.getText().trim();
    String numero = jTextField6.getText().trim();
    String complemento = jTextField7.getText().trim();
    String bairro = jTextField8.getText().trim();
    String cidade = jTextField9.getText().trim();
    String uf = String.valueOf(jComboBox2.getSelectedItem());

    String curso = CampoCurso.getText().trim();
    String instituicao = CampoEnsino.getText().trim();
    String escolaridade =
            String.valueOf(CampoEscolaridade.getSelectedItem());

    String cargo = CampoCargoDesejado.getText().trim();
    String area = String.valueOf(Campointeresse.getSelectedItem());
    String nivel = String.valueOf(CampoProfissional.getSelectedItem());
    String tipo = String.valueOf(CampoTipo.getSelectedItem());
    String resumo = jTextArea1.getText().trim();

    String github = CampoGit.getText().trim();
    String linkedin = CampoLinkedin.getText().trim();

       if (nome.isEmpty()
        || cpf.replaceAll("\\D", "").length() != 11
        || nascimento.replaceAll("\\D", "").length() != 8
        || email.isEmpty()
        || senha.isEmpty()
        || telefone.replaceAll("\\D", "").length() < 10
        || cep.replaceAll("\\D", "").length() != 8
        || logradouro.isEmpty()
        || numero.isEmpty()
        || bairro.isEmpty()
        || cidade.isEmpty()
        || curso.isEmpty()
        || instituicao.isEmpty()
        || cargo.isEmpty()
        || resumo.isEmpty()
        || jComboBox1.getSelectedItem() == null
        || "Escolher".equals(jComboBox1.getSelectedItem())
        || jComboBox2.getSelectedItem() == null
        || "Escolher".equals(jComboBox2.getSelectedItem())
        || CampoEscolaridade.getSelectedItem() == null
        || Campointeresse.getSelectedItem() == null
        || CampoProfissional.getSelectedItem() == null
        || CampoTipo.getSelectedItem() == null) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Verifique os campos obrigatórios e as opções selecionadas.",
            "Cadastro incompleto",
            javax.swing.JOptionPane.WARNING_MESSAGE
    );
    return;
}

    if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Digite um e-mail válido.",
                "E-mail inválido",
                javax.swing.JOptionPane.WARNING_MESSAGE
        );

        jTextField3.requestFocus();
        return;
    }
    Object itemSexualidade = jComboBox1.getSelectedItem();
    if ("Selecione".equals(escolaridade)
            || "Selecione".equals(nivel)
            || "Selecione".equals(tipo)
            || "Selecione".equals(area)
            || "Escolher".equals(itemSexualidade)
            || "UF".equals(uf)) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Selecione as opções obrigatórias nas listas.",
                "Cadastro incompleto",
                javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    java.util.List<String> linguagensSelecionadas =
            jList2.getSelectedValuesList();

    if (linguagensSelecionadas.isEmpty()) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Selecione pelo menos uma linguagem de programação.",
                "Cadastro incompleto",
                javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }
    
    modelo.Sexualidade sexualidadeSelecionadaObj = (modelo.Sexualidade) jComboBox1.getSelectedItem();

    modelo.Candidato candidato = new modelo.Candidato();
    
    // 2. Associa o objeto de sexualidade ao candidato
    candidato.setSexualidade(sexualidadeSelecionadaObj);

    candidato.setNome(nome);
    candidato.setCpf(cpf);
    candidato.setNascimento(nascimento);
    candidato.setEmail(email);
    candidato.setSenha(senha);
    candidato.setTelefone(telefone);

    candidato.setCep(cep);
    candidato.setLogradouro(logradouro);
    candidato.setNumero(numero);
    candidato.setComplemento(complemento);
    candidato.setBairro(bairro);
    candidato.setCidade(cidade);
    candidato.setUf(uf);

    candidato.setCurso(curso);
    candidato.setInstituicao(instituicao);
    candidato.setEscolaridade(escolaridade);

    candidato.setCargoDesejado(cargo);
    candidato.setAreaInteresse(area);
    candidato.setNivelProfissional(nivel);
    candidato.setTipoTrabalho(tipo);
    candidato.setResumo(resumo);
    candidato.setLinguagens(
            String.join(", ", linguagensSelecionadas)
    );

    candidato.setGithub(github);
    candidato.setLinkedin(linkedin);

    dao.CandidatoDao candidatoDao = new dao.CandidatoDao();

    boolean salvou = candidatoDao.inserir(candidato);

    if (salvou) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Cadastro realizado com sucesso!",
                "DevJobs",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
    } else {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Não foi possível salvar o cadastro no banco de dados."
                + "\nVerifique a conexão e tente novamente.",
                "Erro ao cadastrar",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
    }
     
    private void limparCadastro() {

        int resposta = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente limpar todos os campos?",
                "Confirmar limpeza",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (resposta != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        jTextField1.setText("");
        jFormattedTextField1.setValue(null);
        jFormattedTextField3.setValue(null);
        jTextField3.setText("");
        jFormattedTextField2.setValue(null);

        jFormattedTextField4.setValue(null);
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");

        CampoCurso.setText("");
        CampoEnsino.setText("");

        CampoCargoDesejado.setText("");
        jTextArea1.setText("");

        CampoGit.setText("");
        CampoLinkedin.setText("");

        if (CampoEscolaridade.getItemCount() > 0) {
            CampoEscolaridade.setSelectedIndex(0);
        }

        if (CampoProfissional.getItemCount() > 0) {
            CampoProfissional.setSelectedIndex(0);
        }

        if (CampoTipo.getItemCount() > 0) {
            CampoTipo.setSelectedIndex(0);
        }

        if (Campointeresse.getItemCount() > 0) {
            Campointeresse.setSelectedIndex(0);
        }

        if (jComboBox1.getItemCount() > 0) {
            jComboBox1.setSelectedIndex(0);
        }

        if (jComboBox2.getItemCount() > 0) {
            jComboBox2.setSelectedIndex(0);
        }


        jList2.clearSelection();

          carregarFotoPadrao();

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Campos limpos com sucesso.",
                "DevJobs",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLogo = new javax.swing.JLabel();
        jmensagemlogo = new javax.swing.JLabel();
        SairBotao = new javax.swing.JButton();
        InicioBotao = new javax.swing.JButton();
        VagasBotao = new javax.swing.JButton();
        MeuPerflBotao = new javax.swing.JButton();
        jAlterarFoto = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPainelFundo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        CancelarBotao = new javax.swing.JButton();
        SalvaContinuarBotao = new javax.swing.JButton();
        CampoGit = new javax.swing.JTextField();
        LogoGit = new javax.swing.JLabel();
        CampoLinkedin = new javax.swing.JTextField();
        Links = new javax.swing.JLabel();
        LogoLinkedin = new javax.swing.JLabel();
        CampoLinguagem = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        AdicionarBotao = new javax.swing.JButton();
        Escolaridade = new javax.swing.JLabel();
        CampoEscolaridade = new javax.swing.JComboBox<>();
        jLinguagemP = new javax.swing.JLabel();
        CampoCurso = new javax.swing.JTextField();
        jCurso = new javax.swing.JLabel();
        CampoEnsino = new javax.swing.JTextField();
        jEnsino = new javax.swing.JLabel();
        jFormacaoehabilidades = new javax.swing.JLabel();
        j3 = new javax.swing.JLabel();
        jTexto = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jResumo = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        CampoResumo = new javax.swing.JLabel();
        CampoProfissional = new javax.swing.JComboBox<>();
        jProfissional = new javax.swing.JLabel();
        CampoTipo = new javax.swing.JComboBox<>();
        jTipo = new javax.swing.JLabel();
        Campointeresse = new javax.swing.JComboBox<>();
        jinteresse = new javax.swing.JLabel();
        CampoCargoDesejado = new javax.swing.JTextField();
        jCargoDesejado = new javax.swing.JLabel();
        j2 = new javax.swing.JLabel();
        jPerfil = new javax.swing.JLabel();
        jTexto2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 1050));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(12, 50, 111));

        jPanel2.setBackground(new java.awt.Color(12, 50, 111));
        jPanel2.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 1350));
        jPanel2.setPreferredSize(new java.awt.Dimension(1300, 1300));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLogo.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLogo.setForeground(new java.awt.Color(180, 200, 220));
        jLogo.setText("</> DevJobs");
        jPanel2.add(jLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 30));

        jmensagemlogo.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jmensagemlogo.setForeground(new java.awt.Color(180, 200, 220));
        jmensagemlogo.setText("<html>Conectando talentos<br>ao futuro da tecnologia</html>");
        jPanel2.add(jmensagemlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 160, 40));

        SairBotao.setBackground(new java.awt.Color(19, 81, 180));
        SairBotao.setForeground(new java.awt.Color(255, 255, 255));
        SairBotao.setText("     Sair");
        SairBotao.setBorderPainted(false);
        SairBotao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SairBotao.setMaximumSize(new java.awt.Dimension(102, 102));
        SairBotao.setMinimumSize(new java.awt.Dimension(102, 102));
        SairBotao.setPreferredSize(new java.awt.Dimension(102, 102));
        SairBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairBotaoActionPerformed(evt);
            }
        });
        jPanel2.add(SairBotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 130, 50));

        InicioBotao.setBackground(new java.awt.Color(12, 50, 111));
        InicioBotao.setForeground(new java.awt.Color(255, 255, 255));
        InicioBotao.setText("     Inicio");
        InicioBotao.setBorderPainted(false);
        InicioBotao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        InicioBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioBotaoActionPerformed(evt);
            }
        });
        jPanel2.add(InicioBotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 130, 50));

        VagasBotao.setBackground(new java.awt.Color(12, 50, 111));
        VagasBotao.setForeground(new java.awt.Color(255, 255, 255));
        VagasBotao.setText("     Vagas");
        VagasBotao.setBorderPainted(false);
        VagasBotao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        VagasBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VagasBotaoActionPerformed(evt);
            }
        });
        jPanel2.add(VagasBotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 130, 50));

        MeuPerflBotao.setBackground(new java.awt.Color(12, 50, 111));
        MeuPerflBotao.setForeground(new java.awt.Color(255, 255, 255));
        MeuPerflBotao.setText("  Meu Perfil");
        MeuPerflBotao.setBorderPainted(false);
        MeuPerflBotao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MeuPerflBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeuPerflBotaoActionPerformed(evt);
            }
        });
        jPanel2.add(MeuPerflBotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 130, 50));

        jAlterarFoto.setBackground(new java.awt.Color(19, 81, 180));
        jAlterarFoto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 230, 240));
        jLabel3.setText("Cadastro de Perfil Profissional");
        jAlterarFoto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 30));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 230, 240));
        jLabel4.setText("Complete suas informações para aumentar suas chances de encontrar a vaga ideal.");
        jAlterarFoto.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 700, 20));

        jPanel2.add(jAlterarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 1150, 80));

        jPainelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jPainelFundo.setPreferredSize(new java.awt.Dimension(994, 1228));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        CancelarBotao.setText("Cancelar");
        CancelarBotao.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        SalvaContinuarBotao.setBackground(new java.awt.Color(19, 81, 180));
        SalvaContinuarBotao.setForeground(new java.awt.Color(255, 255, 255));
        SalvaContinuarBotao.setText("Salvar e Continuar");
        SalvaContinuarBotao.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        SalvaContinuarBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalvaContinuarBotaoMouseClicked(evt);
            }
        });

        CampoGit.setText("campoGithub");

        LogoGit.setBackground(new java.awt.Color(0, 0, 0));
        LogoGit.setText("GH");
        LogoGit.setOpaque(true);

        CampoLinkedin.setText("campoLinkedin");

        Links.setText("Links profissionais (opcional)");

        LogoLinkedin.setBackground(new java.awt.Color(0, 119, 181));
        LogoLinkedin.setText("in");
        LogoLinkedin.setOpaque(true);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        CampoLinguagem.setViewportView(jList2);
        jList2.getAccessibleContext().setAccessibleName("");

        AdicionarBotao.setText("Adicionar Selecionadas");

        Escolaridade.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        Escolaridade.setText("Escolaridade *");

        CampoEscolaridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLinguagemP.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLinguagemP.setText("Linguagens de Programação (Selecione uma ou mais com Ctrl/Shift) *");

        jCurso.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jCurso.setText("Curso *");

        jEnsino.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jEnsino.setText("Instituição de ensino *");

        jFormacaoehabilidades.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jFormacaoehabilidades.setForeground(new java.awt.Color(12, 50, 111));
        jFormacaoehabilidades.setText("Formação e habilidades");

        j3.setBackground(new java.awt.Color(19, 81, 180));
        j3.setForeground(new java.awt.Color(255, 255, 255));
        j3.setText("3");
        j3.setOpaque(true);

        jTexto.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jTexto.setForeground(new java.awt.Color(153, 153, 153));
        jTexto.setText("Conhecimentos do candidato");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(251, 251, 251)
                            .addComponent(CancelarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SalvaContinuarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CampoEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Escolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jEnsino)
                                .addComponent(CampoEnsino, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(CampoLinguagem, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AdicionarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLinguagemP, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCurso)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormacaoehabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Links, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(LogoLinkedin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoLinkedin, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(LogoGit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoGit, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(j3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFormacaoehabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Escolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEnsino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoEnsino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLinguagemP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoLinguagem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(AdicionarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)))
                .addComponent(Links, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoLinkedin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoLinkedin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoGit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoGit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalvaContinuarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jResumo.setViewportView(jTextArea1);

        CampoResumo.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        CampoResumo.setText("Resumo profissional *");

        CampoProfissional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jProfissional.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jProfissional.setText("Nível profissional *");

        CampoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTipo.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jTipo.setText("Tipo de trabalho *");

        Campointeresse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jinteresse.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jinteresse.setText("Área de interesse *");

        CampoCargoDesejado.setActionCommand("<Not Set>");

        jCargoDesejado.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jCargoDesejado.setText("Cargo desejado *");

        j2.setBackground(new java.awt.Color(19, 81, 180));
        j2.setForeground(new java.awt.Color(255, 255, 255));
        j2.setText("2");
        j2.setOpaque(true);

        jPerfil.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jPerfil.setForeground(new java.awt.Color(12, 50, 111));
        jPerfil.setText("Perfil profissional");

        jTexto2.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jTexto2.setForeground(new java.awt.Color(153, 153, 153));
        jTexto2.setText("Informações para encontrar oportunidades");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CampoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoCargoDesejado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCargoDesejado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jinteresse, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campointeresse, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jResumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoResumo)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPerfil))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jinteresse, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCargoDesejado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Campointeresse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoCargoDesejado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoResumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jResumo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(12, 50, 111));
        jLabel6.setText("Dados pessoais e Endereço");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 500, 25));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Identificação e contato do candidato");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 500, 15));

        jLabel8.setText("foto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 80));

        jButton5.setText("Alterar Foto");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 160, 90, 25));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 9)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Opcional");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 185, 90, 15));

        jLabel10.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel10.setText("Nome completo *");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 300, 20));

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 250, 30));

        jLabel11.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel11.setText("CPF *");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 200, 20));

        jFormattedTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        jFormattedTextField1.setText("___-___-___-__");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 150, 30));

        jLabel12.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel12.setText("Data de Nascimento *");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 200, 20));

        jLabel13.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel13.setText("E-mail *");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 200, 20));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 250, 30));

        jLabel14.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel14.setText("Telefone *");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 200, 20));

        jFormattedTextField2.setText("(  )_____-____");
        jPanel1.add(jFormattedTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 150, 30));

        jLabel15.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel15.setText("Sexualidade *");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 200, 20));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 200, 30));

        jLabel16.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel16.setText("CEP *");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 200, 20));

        jLabel17.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel17.setText("Logradouro *");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 200, 20));
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 250, 30));

        jLabel18.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel18.setText("Número *");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 200, 20));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 80, 30));

        jLabel19.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel19.setText("Complemento");
        jLabel19.setToolTipText("");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 200, 20));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 100, 30));

        jLabel20.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel20.setText("Bairro *");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 200, 20));

        jTextField8.setActionCommand("<Not Set>");
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 200, 30));

        jLabel21.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel21.setText("Cidade *");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 200, 20));
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 200, 30));

        jLabel22.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel22.setText("Senha*");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 80, 20));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 80, 30));

        jLabel33.setBackground(new java.awt.Color(19, 81, 180));
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("1");
        jLabel33.setMaximumSize(new java.awt.Dimension(15, 15));
        jLabel33.setMinimumSize(new java.awt.Dimension(28, 28));
        jLabel33.setOpaque(true);
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 28, 28));

        jFormattedTextField3.setText("__/__/____");
        jPanel1.add(jFormattedTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 150, 30));

        jFormattedTextField4.setText("_____-___");
        jPanel1.add(jFormattedTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 100, 30));

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 160, 30));

        jLabel23.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jLabel23.setText("UF *");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 80, 20));

        javax.swing.GroupLayout jPainelFundoLayout = new javax.swing.GroupLayout(jPainelFundo);
        jPainelFundo.setLayout(jPainelFundoLayout);
        jPainelFundoLayout.setHorizontalGroup(
            jPainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelFundoLayout.createSequentialGroup()
                .addGroup(jPainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPainelFundoLayout.setVerticalGroup(
            jPainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelFundoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(369, Short.MAX_VALUE))
        );

        jPanel2.add(jPainelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 1060, 1510));

        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 1240));
        jScrollPane1.getAccessibleContext().setAccessibleName("scrollPrincipal");

        getAccessibleContext().setAccessibleName("DevJobs - Cadastro de Perfil");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairBotaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SairBotaoActionPerformed

    private void InicioBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBotaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioBotaoActionPerformed

    private void VagasBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VagasBotaoActionPerformed
        TelaVagas vagas = new TelaVagas();
        vagas.setLocationRelativeTo(null);
        vagas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VagasBotaoActionPerformed

    private void MeuPerflBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeuPerflBotaoActionPerformed
       // TODO add your handling code here:
}
    private void aplicarVisualModerno() {
    java.awt.Color azul = new java.awt.Color(19, 81, 180);
    java.awt.Color azulEscuro = new java.awt.Color(12, 50, 111);
    java.awt.Color fundo = new java.awt.Color(245, 247, 251);
    java.awt.Color branco = java.awt.Color.WHITE;
    java.awt.Color texto = new java.awt.Color(40, 50, 65);
    java.awt.Color cinza = new java.awt.Color(120, 130, 145);
    java.awt.Color borda = new java.awt.Color(220, 226, 235);
    jPanel2.setPreferredSize(new java.awt.Dimension(1300, 1600));
    jPanel2.setMinimumSize(new java.awt.Dimension(1300, 1600));
    jPanel2.setMaximumSize(new java.awt.Dimension(1300, 1600));

    java.awt.Font fonte = new java.awt.Font(
        "Ubuntu", java.awt.Font.PLAIN, 13
    );
    java.awt.Font fonteNegrito = new java.awt.Font(
        "Ubuntu", java.awt.Font.BOLD, 13
    );

    getContentPane().setBackground(fundo);
    setTitle("DevJobs - Cadastro de Perfil");

    jScrollPane1.setBorder(null);
    jScrollPane1.getViewport().setBackground(fundo);
    jPanel2.setBackground(azulEscuro);
    jPainelFundo.setBackground(fundo);

    jLogo.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.BOLD, 21
    ));
    jLogo.setForeground(branco);

    jmensagemlogo.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.PLAIN, 11
    ));
    jmensagemlogo.setForeground(
        new java.awt.Color(195, 210, 235)
    );

    estilizarBotaoMenu(InicioBotao, azulEscuro);
    estilizarBotaoMenu(VagasBotao, azulEscuro);
    estilizarBotaoMenu(MeuPerflBotao, azul);
    estilizarBotaoMenu(SairBotao, azulEscuro);

    jAlterarFoto.setBackground(azul);
    jLabel3.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.BOLD, 23
    ));
    jLabel4.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.PLAIN, 12
    ));

    jLabel3.setForeground(branco);
    jLabel4.setForeground(new java.awt.Color(225, 235, 250));

    estilizarCartao(jPanel1, borda);
    estilizarCartao(jPanel5, borda);
    estilizarCartao(jPanel4, borda);

    jLabel6.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.BOLD, 17
    ));
    jLabel6.setForeground(azulEscuro);

    jPerfil.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.BOLD, 17
    ));
    jPerfil.setForeground(azulEscuro);

    jFormacaoehabilidades.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.BOLD, 17
    ));
    jFormacaoehabilidades.setForeground(azulEscuro);

    jLabel7.setForeground(cinza);
    jTexto.setForeground(cinza);
    jTexto2.setForeground(cinza);

    javax.swing.JLabel[] rotulos = {
        jLabel8, jLabel9, jLabel10, jLabel11, jLabel12,
        jLabel13, jLabel14, jLabel15, jLabel16, jLabel17,
        jLabel18, jLabel19, jLabel20, jLabel21, jLabel22,
        jCurso, jEnsino, Escolaridade, jLinguagemP, Links,
        CampoResumo, jProfissional, jTipo, jinteresse,
        jCargoDesejado
    };

    for (javax.swing.JLabel rotulo : rotulos) {
        rotulo.setFont(fonteNegrito);
        if (rotulo != jLabel8 && rotulo != jLabel9) {
            rotulo.setForeground(texto);
        }
    }

    
    
    javax.swing.JTextField[] campos = {
    CampoCurso, CampoEnsino, CampoGit, CampoLinkedin,
    CampoCargoDesejado, jTextField1, jTextField3,
    jTextField5, jTextField6, jTextField7,
    jTextField8, jTextField9
};


    for (javax.swing.JTextField campo : campos) {
        campo.setFont(fonte);
        campo.setForeground(texto);
        campo.setBackground(branco);
        campo.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(borda),
                javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8)
            )
        );
    }

    
    jFormattedTextField1.setFont(fonte);
    jFormattedTextField2.setFont(fonte);

    javax.swing.JFormattedTextField[] formatados = {
    jFormattedTextField1, jFormattedTextField2,
    jFormattedTextField3, jFormattedTextField4
};

    for (javax.swing.JFormattedTextField campo : formatados) {
        campo.setForeground(texto);
        campo.setBackground(branco);
        campo.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(borda),
                javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8)
            )
        );
    }

    // Listas de seleção
    javax.swing.JComboBox<?>[] combos = {
        CampoEscolaridade, CampoProfissional, CampoTipo,
        Campointeresse, jComboBox1, jComboBox2
    };

    for (javax.swing.JComboBox<?> combo : combos) {
        combo.setFont(fonte);
        combo.setBackground(branco);
        combo.setForeground(texto);
    }

    // Resumo profissional
    jTextArea1.setFont(fonte);
    jTextArea1.setForeground(texto);
    jTextArea1.setBackground(branco);
    jTextArea1.setLineWrap(true);
    jTextArea1.setWrapStyleWord(true);
    jResumo.setBorder(
        javax.swing.BorderFactory.createLineBorder(borda)
    );

    // Lista de linguagens
    jList2.setFont(fonte);
    jList2.setForeground(texto);
    jList2.setBackground(branco);
    jList2.setSelectionBackground(azul);
    jList2.setSelectionForeground(branco);
    CampoLinguagem.setBorder(
        javax.swing.BorderFactory.createLineBorder(borda)
    );

    // Botões de ação
    estilizarBotaoPrincipal(SalvaContinuarBotao, azul);
    estilizarBotaoSecundario(CancelarBotao, borda, texto);
    estilizarBotaoSecundario(AdicionarBotao, borda, azulEscuro);
    estilizarBotaoSecundario(jButton5, borda, azulEscuro);

    // Identificadores das etapas
    jLabel33.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.BOLD, 13
    ));
    jLabel33.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );
    jLabel33.setBackground(azul);
    jLabel33.setForeground(branco);

    j2.setFont(fonteNegrito);
    j2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    j2.setBackground(azul);
    j2.setForeground(branco);

    j3.setFont(fonteNegrito);
    j3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    j3.setBackground(azul);
    j3.setForeground(branco);

    // Identificadores do GitHub e LinkedIn
    LogoGit.setForeground(branco);
    LogoGit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LogoLinkedin.setForeground(branco);
    LogoLinkedin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    // Ajuste visual dos painéis
    jPanel1.setBackground(branco);
    jPanel5.setBackground(branco);
    jPanel4.setBackground(branco);

    revalidate();
    repaint();
}

private void estilizarCartao(
        javax.swing.JPanel painel, java.awt.Color borda) {
    painel.setBackground(java.awt.Color.WHITE);
    painel.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(borda),
            javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8)
        )
    );
}

private void estilizarBotaoMenu(
        javax.swing.JButton botao, java.awt.Color corFundo) {
    botao.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.BOLD, 13
    ));
    botao.setBackground(corFundo);
    botao.setForeground(java.awt.Color.WHITE);
    botao.setBorderPainted(false);
    botao.setFocusPainted(false);
    botao.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );
}

private void estilizarBotaoPrincipal(
        javax.swing.JButton botao, java.awt.Color azul) {
    botao.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.BOLD, 13
    ));
    botao.setBackground(azul);
    botao.setForeground(java.awt.Color.WHITE);
    botao.setBorderPainted(false);
    botao.setFocusPainted(false);
    botao.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );
}

private void estilizarBotaoSecundario(
        javax.swing.JButton botao,
        java.awt.Color borda,
        java.awt.Color texto) {
        botao.setFont(new java.awt.Font(
        "Ubuntu", java.awt.Font.BOLD, 12
    ));
    botao.setBackground(java.awt.Color.WHITE);
    botao.setForeground(texto);
    botao.setBorder(
        javax.swing.BorderFactory.createLineBorder(borda)
    );
    botao.setFocusPainted(false);
    botao.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );

    }//GEN-LAST:event_MeuPerflBotaoActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void SalvaContinuarBotaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalvaContinuarBotaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SalvaContinuarBotaoMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaCadastro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarBotao;
    private javax.swing.JTextField CampoCargoDesejado;
    private javax.swing.JTextField CampoCurso;
    private javax.swing.JTextField CampoEnsino;
    private javax.swing.JComboBox<String> CampoEscolaridade;
    private javax.swing.JTextField CampoGit;
    private javax.swing.JScrollPane CampoLinguagem;
    private javax.swing.JTextField CampoLinkedin;
    private javax.swing.JComboBox<String> CampoProfissional;
    private javax.swing.JLabel CampoResumo;
    private javax.swing.JComboBox<String> CampoTipo;
    private javax.swing.JComboBox<String> Campointeresse;
    private javax.swing.JButton CancelarBotao;
    private javax.swing.JLabel Escolaridade;
    private javax.swing.JButton InicioBotao;
    private javax.swing.JLabel Links;
    private javax.swing.JLabel LogoGit;
    private javax.swing.JLabel LogoLinkedin;
    private javax.swing.JButton MeuPerflBotao;
    private javax.swing.JButton SairBotao;
    private javax.swing.JButton SalvaContinuarBotao;
    private javax.swing.JButton VagasBotao;
    private javax.swing.JLabel j2;
    private javax.swing.JLabel j3;
    private javax.swing.JPanel jAlterarFoto;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jCargoDesejado;
    private javax.swing.JComboBox<modelo.Sexualidade> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jCurso;
    private javax.swing.JLabel jEnsino;
    private javax.swing.JLabel jFormacaoehabilidades;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLinguagemP;
    private javax.swing.JList<String> jList2;
    private javax.swing.JLabel jLogo;
    private javax.swing.JPanel jPainelFundo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jPerfil;
    private javax.swing.JLabel jProfissional;
    private javax.swing.JScrollPane jResumo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel jTexto;
    private javax.swing.JLabel jTexto2;
    private javax.swing.JLabel jTipo;
    private javax.swing.JLabel jinteresse;
    private javax.swing.JLabel jmensagemlogo;
    // End of variables declaration//GEN-END:variables
}
