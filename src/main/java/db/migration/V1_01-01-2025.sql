/*
    Selecionar a constraint e dropar da tabela
*/
select constraint_name from information_schema.constraint_column_usage
where table_name = 'usuario_acesso' and column_name = 'acesso_id' and constraint_name <> 'unique_user_acess'; 

alter table usuario_acesso drop CONSTRAINT "usuario_acesso_acesso_id_key"