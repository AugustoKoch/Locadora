create database db_locadora;
use db_locadora;

/*
Neste ponto você deve rodar a aplicação para que as tabelas sejam criadas
*/

INSERT INTO cliente (id, nome, CPF, endereco, telefone) VALUES
('1', 'Alice Silva', '123.456.789-10', 'Rua das Flores, 123', '(11) 98765-4321'),
('2', 'Bob Santos', '987.654.321-00', 'Avenida Principal, 456', '(22) 12345-6789'),
('3', 'Carla Oliveira', '321.654.987-01', 'Praça Central, 789', '(33) 54321-9876');

INSERT INTO veiculo (id, modelo, placa, ano) VALUES
('1', 'Toyota Corolla', 'ABC1234', 2020),
('2', 'Ford Mustang', 'DEF5678', 2019),
('3', 'Volkswagen Gol', 'GHI9012', 2018);

INSERT INTO reserva (id, inicio, fim, veiculo_id, cliente_id) VALUES
('1', '2024-05-03', '2024-05-10', 1, 1),
('2', '2024-05-05', '2024-05-08', 2, 2),
('3', '2024-05-07', '2024-05-12', 3, 3);
