async function listarFilmes() {
  let resposta = await fetch("https://api-filmes-production-9408.up.railway.app/filmes");
  let filmes = await resposta.json();

  let filmesAcao = filmes.filter(filmes => filmes.genero === "Ação");

  filmesAcao.forEach(filme => {
    console.log(`${filme.titulo} - ${filme.ano} -> ${filme.genero}`);
  });
}
listarFilmes();