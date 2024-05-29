  //Aula 1 - Server básico e Endpoints
  var express = require("express");
  var app = express();
  var bodyParser = require("body-parser");
  const { ERROR } = require("sqlite3");
  const bcrypt = require('bcryptjs');
  var port = process.env.PORT || 8081;

  const sqlite3 = require('sqlite3').verbose();

  let db = new sqlite3.Database("ntpica.db");

  app.use(bodyParser.json());

  app.use(bodyParser.urlencoded({ extended: true }));

  app.get("/", function(req, res){
    res.send("SERVER RODANDO")
  });

  //PRATOS ATE 1500 KCAL

  app.get("/pratos1500cafe", function(req, res){
    const busca = "SELECT CAFE FROM PRATO1500 ORDER BY RANDOM() LIMIT 1";


    db.get(busca, (err, row) => {
        if(err){
            console.error("ERRO NA BUSCA DE DADOS: ", err);
            res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
        } else {
          console.log("DADOS RETORNADOS: ", {CAFE: row});
          res.json({CAFE: row});
        }    
    });
  });


  app.get("/pratos1500almoco", function(req, res){
    const busca = "SELECT ALMOCO FROM PRATO1500 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {ALMOCO: row});
        res.json({ALMOCO: row});
      }    
    });
  });

  app.get("/pratos1500jantar", function(req, res){
    const busca = "SELECT JANTAR FROM PRATO1500 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {JANTAR: row});
        res.json({JANTAR: row});
      }    
    });
  });

  //PRATOS ATÉ 1700 KCAL

  app.get("/pratos1700cafe", function(req, res){
    const busca = "SELECT CAFE FROM PRATO1700 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {CAFE: row});
        res.json({CAFE: row});
      }    
    });
  });

  app.get("/pratos1700almoco", function(req, res){
    const busca = "SELECT ALMOCO FROM PRATO1700 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {ALMOCO: row});
        res.json({ALMOCO: row});
      }    
    });
  });

  app.get("/pratos1700jantar", function(req, res){
    const busca = "SELECT JANTA FROM PRATO1700 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {JANTA: row});
        res.json({JANTA: row});
      }    
    });
  });

  //PRATOS COM 1900 KCAL
  app.get("/pratos1900cafe", function(req, res){
    const busca = "SELECT CAFE FROM PRATO1900 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {CAFE: row});
        res.json({CAFE: row});
      }    
    });
  });

  app.get("/pratos1900almoco", function(req, res){
    const busca = "SELECT ALMOCO FROM PRATO1900 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {ALMOCO: row});
        res.json({ALMOCO: row});
      }    
    });
  });

  app.get("/pratos1900jantar", function(req, res){
    const busca = "SELECT JANTA FROM PRATO1900 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {JANTA: row});
        res.json({JANTA: row});
      }    
    });
  });

  //PRATOS COM 2100 KCAL

  app.get("/pratos2100cafe", function(req, res){
    const busca = "SELECT CAFE FROM PRATO2100 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {CAFE: row});
        res.json({CAFE: row});
      }    
    });
  });

  app.get("/pratos2100almoco", function(req, res){
    const busca = "SELECT ALMOCO FROM PRATO2100 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {ALMOCO: row});
        res.json({ALMOCO: row});
      }    
    });
  });

  app.get("/pratos2100jantar", function(req, res){
    const busca = "SELECT JANTA FROM PRATO2100 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {JANTA: row});
        res.json({JANTA: row});
      }    
    });
  });

  //PRATOS 2300

  app.get("/pratos2300cafe", function(req, res){
    const busca = "SELECT CAFE FROM PRATO2300 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {CAFE: row});
        res.json({CAFE: row});
      }    
    });
  });

  app.get("/pratos2300almoco", function(req, res){
    const busca = "SELECT ALMOCO FROM PRATO2300 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {ALMOCO: row});
        res.json({ALMOCO: row});
      }    
    });
  });

  app.get("/pratos2300jantar", function(req, res){
    const busca = "SELECT JANTA FROM PRATO2300 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {JANTA: row});
        res.json({JANTA: row});
      }    
    });
  });


  //PRATOS 2500
  app.get("/pratos2500cafe", function(req, res){
    const busca = "SELECT CAFE FROM PRATO2500 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {CAFE: row});
        res.json({CAFE: row});
      }    
    });
  });

  app.get("/pratos2500almoco", function(req, res){
    const busca = "SELECT ALMOCO FROM PRATO2500 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {ALMOCO: row});
        res.json({ALMOCO: row});
      }    
    });
  });

  app.get("/pratos2500jantar", function(req, res){
    const busca = "SELECT JANTA FROM PRATO2500 ORDER BY RANDOM() LIMIT 1";

    db.get(busca, (err, row) => {
      if (err) {
          console.error("ERRO NA BUSCA DE DADOS: ", err);
          res.status(500).json({mensagem: "ERRO AO BUSCAR DADOS"});
      } else {
        console.log("DADOS RETORNADOS: ", {JANTA: row});
        res.json({JANTA: row});
      }    
    });
  });



  //ROTA REGISTRO

  app.post('/criarUsuario', function(req, res){
    const {email, senha, nome, idade, telefone, peso} = req.body;
    const hash = bcrypt.hashSync(senha, 10);
    db.run(`INSERT INTO users (nome, idade, telefone, peso, email, senha) VALUES (?, ?, ?, ?, ?, ?)`, [nome, idade, telefone, peso, email, hash], function(err){
        if(err){
          return console.error(err.message);
        }
        console.log("DADOS INSERIDOS COM SUCESSO");
        res.send("DADOS ENVIADOS COM SUCESSO");
    });
  });


  //ROTA LOGIN 

  app.post('/login', (req, res) => {
    const { email, senha } = req.body;

    console.log('Tentativa de login:', email);

    db.get('SELECT * FROM users WHERE email = ?', [email], (err, row) => {
      if (err) {
        console.error('Erro ao buscar usuário:', err.message);
        return res.status(500).send('Erro no servidor');
      }

      if (row) {
        console.log('Usuário encontrado:', row);

        bcrypt.compare(senha, row.senha, (err, result) => {
          if (err) {
            console.error('Erro ao comparar senhas:', err.message);
            return res.status(500).send('Erro no servidor');
          }

          if (result) {
            console.log('Senha correta para usuário:', email);
            const { nome, idade, telefone, peso } = row;

            
            const userInfo = { nome, idade, telefone, peso };

            
            console.log('Resposta JSON:', { message: 'Login bem-sucedido', userInfo });
            res.json({ message: 'Login bem-sucedido', userInfo });
          } else {
            console.log('Senha incorreta para usuário:', email);
            res.status(401).json({ message: 'Credenciais inválidas' });
          }
        });
      } else {
        console.log('Usuário não encontrado:', email);
        res.status(401).json({ message: 'Credenciais inválidas' });
      }
    });
  });


  //ROTA DE ALIMENTOS

  app.get("/alimentos", function(req, res) {
    const buscaAlimentos = "SELECT nome, kcal FROM alimentos";
    db.all(buscaAlimentos, [], (err, rows) => {
      if (err) {
        console.error(err.message);
        res.status(500).json({ mensagem: "ERRO AO BUSCAR DADOS" });
      } else {
        console.log("DADOS RETORNADOS: ", { ALIMENTOS: rows });
        res.json({ ALIMENTOS: rows });
      }    
    });
  });

  app.post("/addAlimentos", function(req, res){
    const {nome, kcal} = req.body;
    db.run(`INSERT INTO ALIMENTOS (nome , kcal) VALUES (?, ?)`, [nome , kcal], function(err){
      if(err){
        return console.error("ERRO AO INSERIR ALIEMENTOS", err)
      }else{
        console.log("DADOS INSERIDOS COM SUCESSO");
        res.send("DADOS ENVIADOS COM SUCESSO");
      }
    });
  });
  
  app.listen(port);
  console.log("esta rodando na porta:", port);

