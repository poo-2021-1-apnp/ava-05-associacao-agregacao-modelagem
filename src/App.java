import model.Autor;
import model.Editora;
import model.Livro;

class App {
  public static void main(String[] args) {
    System.out.println("Olá mundo!");

    Editora record = new Editora("Record");
    System.out.println(record.getNome().equals("Record"));

    Editora wmf = new Editora("WMF");
    System.out.println(wmf.getNome().equals("WMF"));

    Autor gleiser = new Autor("Marcelo Gleiser");
    System.out.println(gleiser.getNome().equals("Marcelo Gleiser"));

    Autor sponville = new Autor("André Comte-Sponville");
    System.out.println(sponville.getNome().equals("André Comte-Sponville"));

    Livro caldeiraoAzul = new Livro("O caldeirão azul", gleiser, 2019, record);
    System.out.println(caldeiraoAzul.getTitulo().equals("O caldeirão azul"));
    System.out.println(caldeiraoAzul.getAutor().equals(gleiser));
    System.out.println(caldeiraoAzul.getAno() == 2019);
    System.out.println(caldeiraoAzul.getEditora().equals(record));

    Livro criacaoImperfeita = new Livro("Criação imperfeita", gleiser, 2010, record);
    System.out.println(criacaoImperfeita.getTitulo().equals("Criação imperfeita"));
    System.out.println(criacaoImperfeita.getAutor().equals(gleiser));
    System.out.println(criacaoImperfeita.getAno() == 2010);
    System.out.println(criacaoImperfeita.getEditora().equals(record));

    Livro pequenoTratado = new Livro("Pequeno tratado das grandes virtudes", sponville, 2016, wmf);
    System.out.println(pequenoTratado.getTitulo().equals("Pequeno tratado das grandes virtudes"));
    System.out.println(pequenoTratado.getAutor().equals(sponville));
    System.out.println(pequenoTratado.getAno() == 2016);
    System.out.println(pequenoTratado.getEditora().equals(wmf));

    Livro felicidadeDesesperadamente = new Livro("A Felicidade, Desesperadamente", sponville, 2015, wmf);
    System.out.println(felicidadeDesesperadamente.getTitulo().equals("A Felicidade, Desesperadamente"));
    System.out.println(felicidadeDesesperadamente.getAutor().equals(sponville));
    System.out.println(felicidadeDesesperadamente.getAno() == 2015);
    System.out.println(felicidadeDesesperadamente.getEditora().equals(wmf));

    Perfil meuPerfil = new Perfil("Seu Nome Aqui");
    System.out.println(meuPerfil.getNome().equals("Seu Nome Aqui"));
    // retorna ArrayList
    System.out.println(meuPerfil.getListas().size() == 0);
    // se a lista não existe retorna null
    ListaDesejos naoExiste = meuPerfil.getListaDesejos("Uma Lista Que Não Existe");
    System.out.println(naoExiste == null);

    // armazena internamente e devolve
    ListaDesejos minhaLista = meuPerfil.criarNovaListaDesejos("Minha lista");
    System.out.println(minhaLista != null);
    System.out.println(minhaLista.getNome().equals("Minha lista"));
    System.out.println(meuPerfil.getListas().size() == 1);
    // adicionar dois livros à lista
    minhaLista.adicionar(caldeiraoAzul);
    minhaLista.adicionar(pequenoTratado);

    System.out.println(minhaLista.getLivros()); // imprime os dois livros
    // quais livros?
    System.out.println(minhaLista.getLivro(0).equals(caldeiraoAzul));
    System.out.println(minhaLista.getLivro(1).equals(pequenoTratado));
    // getLivros() devolve o ArrayList
    System.out.println(minhaLista.getLivros().get(0).equals(caldeiraoAzul));
    System.out.println(minhaLista.getLivros().get(1).equals(pequenoTratado));

    // nova lista
    ListaDesejos listaUrgente = meuPerfil.criarNovaListaDesejos("Comprar Urgente");
    System.out.println(listaUrgente != null);
    System.out.println(listaUrgente.getNome().equals("Comprar Urgente"));
    System.out.println(meuPerfil.getListas().size() == 2);
    // adiciona um livro
    listaUrgente.adicionar(felicidadeDesesperadamente);

    // obtém novamente uma referência à primeira lista
    ListaDesejos lista = meuPerfil.getListaDesejos("Minha lista");
    // adiciona mais um livro à Minha Lista
    lista.adicionar(criacaoImperfeita);

    // adicionar mais um livro na segunda lista
    meuPerfil.getListaDesejos("Comprar Urgente").adicionar(criacaoImperfeita);

    // assumindo que a lista Comprar Urgente tem dois livros
    System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getQuantidade() == 2);
    System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getLivro(0).equals(felicidadeDesesperadamente));
    System.out.println(meuPerfil.getListaDesejos("Comprar Urgente").getLivro(1).equals(criacaoImperfeita));

    // navegando no grafo de objetos
    System.out.println(meuPerfil.getListaDesejos("Minha lista").getLivro(0).getAutor().equals(gleiser));

  }
}
