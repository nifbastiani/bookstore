package br.com.bookstore.main;

import java.util.List;

import br.com.bookstore.dao.LivroDAO;
import br.com.bookstore.dao.LivroDAOSqlite;
import br.com.bookstore.model.Livro;

public class Main {
    public static void main(String[] args) {
        LivroDAO dao = new LivroDAOSqlite();

        Livro l1 = new Livro("Clean Code", "Robert C. Martin", 89.90);
        Livro l2 = new Livro("Design Patterns", "Erich Gamma", 119.50);
        Livro l3 = new Livro("Refactoring", "Martin Fowler", 99.00);
    
        dao.salvar(l1);
        dao.salvar(l2);
        dao.salvar(l3);

        System.out.println("=== IDs gerados após salvar ===");
        System.out.println("Livro 1 ID: " + l1.getId() + " -> " + l1);
        System.out.println("Livro 2 ID: " + l2.getId() + " -> " + l2);
        System.out.println("Livro 3 ID: " + l3.getId() + " -> " + l3);

        System.out.println("\n=== Busca por ID 2 ===");
        dao.buscarPorId(2L).ifPresentOrElse(
            livro -> System.out.println("Encontrado: " + livro),
            () -> System.out.println("Livro com ID 2 não encontrado.")
        );

        System.out.println("\n=== Busca por ID inexistente (999L) ===");
        dao.buscarPorId(999L).ifPresentOrElse(
            livro -> System.out.println("Encontrado: " + livro),
            () -> System.out.println("Aviso: nenhum livro encontrado para o ID 999.")
        );

        System.out.println("\n=== Catálogo Completo (listarTodos) ===");
        List<Livro> livros = dao.listarTodos();
        System.out.printf("%-5s | %-25s | %-20s | %10s%n", "ID", "TÍTULO", "AUTOR", "PREÇO (R$)");
        System.out.println("------+---------------------------+----------------------+-----------");
        for (Livro livro : livros) {
            System.out.printf(
                "%-5d | %-25s | %-20s | %10.2f%n",
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getPreco()
            );
        }
    
    }
}
