//Aula 1 - Server básico e Endpoints
var express = require("express");
var app = express();
var bodyParser = require("body-parser");
var port = process.env.PORT || 3000;
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.post("/cadastro", function (req, res) {
  console.log(req.body);
  console.log("Recebi um dado");
  let nome = req.body.nome;
  let senha = req.body.senha;
  console.log(`Nome: ${nome} Senha: ${senha}`);
  res.send("Recebido");
});
//Aula 2 - Banco de Dados
var sqlite3 = require("sqlite3").verbose();
var DBPATH = "NTP.db";
var db = new sqlite3.Database(DBPATH);
app.get("/tudo", function (req, res) {
  db.all(`SELECT * FROM User`, [], (err, rows) => {
    if (err) {
      res.send(err);
    }
    res.send(rows);
  });
});
app.post("/criarUsuario", function (req, res) {
  var email = req.body.email;
  var senha = req.body.senha;
  sqlBusca = `SELECT * FROM User WHERE email='${email}'`; // Corrigido: Adicionado aspas para o valor de email
  db.all(sqlBusca, [], (err, rows) => {
    if (err) {
      res.send("Erro na busca: " + err);
    } else {
      if (rows.length > 0) {
        res.send("Usuário já existe!");
      } else {
        sqlInsert = `INSERT INTO User (email, senha) VALUES ('${email}', '${senha}')`; // Corrigido: Tabela "User" e adicionado aspas para os valores de email e senha
        db.run(sqlInsert, [], (err) => {
          // Alterado de db.all para db.run para uma operação de inserção
          if (err) {
            res.send("Erro na gravação do banco: " + err);
          } else {
            res.send("Usuário cadastrado!");
          }
        });
      }
    }
  });
});

app.listen(port);
