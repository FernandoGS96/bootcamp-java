document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = 'https://pokeapi.co/api/v2/pokemon?limit=150';
    const pokemonList = document.getElementById('page__main');
    /* const pokemonDetail = document.getElementById('pokemon-detail');
    const searchInput = document.getElementById('search'); */
    
    fetch(apiUrl)
        .then(response => response.json()) //    الكل
        .then(data => {
            const pokemons = data.results;
            pokemons.forEach(pokemon => {
                fetch(pokemon.url)  //  واحد واحد
                    .then(response => response.json())
                    .then(pokemonData => {
                        displayPokemon(pokemonData);
                    });
            });
        });
        

    function displayPokemon(pokemon) {
        const card = document.createElement('article');
        const img = `${pokemon.sprites.front_default}`;
        const tipos= [`${pokemon.types[0].type.name}`, `${pokemon.types[1].type.name}`];
        const tipo1 = `${tipos[0]}`;
        const tipo2 = `${tipos[1]}`;
        card.className = 'pokemon__item';
        card.innerHTML = `
            <div class="pokemon__pic" style="background-image: url('${img}'); alt="${pokemon.name}">
            <footer class = "pk-id">ID/${pokemon.id}</footer>
            </div>
            <h2 class="pk-name">${pokemon.name}</h2>
        <ul class="types">
            <li class="type__item">${tipo1}</li>
            <li class="type__item">${tipo2}</li>
        </ul>
        <div class="pokemon__info-evolution">
            <span class="pokemon__info-evolution-label">Evoluciona de: </span>
            <h3 class="pokemon__info-evolution-name"></h3>
        </div>
        `;
        card.addEventListener('click', () => {
            showPokemonDetail(pokemon);
        });
        pokemonList.appendChild(card);
        
        console.log(card);
        console.log(tipo2);

    }

    /* function showPokemonDetail(pokemon) {
        pokemonDetail.innerHTML = `
            <div class="back-button">Back to List</div>
            <h2>${pokemon.name}</h2>
            <img src="${pokemon.sprites.front_default}" alt="${pokemon.name}">
            <p>ID: ${pokemon.id}</p>
            <p>Type: ${pokemon.types.map(type => type.type.name).join(', ')}</p>
            <p>Weight: ${pokemon.weight}</p>
            <p>Height: ${pokemon.height}</p>
        `;
        document.querySelector('.back-button').addEventListener('click', () => {
            pokemonDetail.classList.add('hidden');
            pokemonList.classList.remove('hidden');
        });
        pokemonList.classList.add('hidden');
        pokemonDetail.classList.remove('hidden');
    } */

    /* searchInput.addEventListener('input', (e) => {
        const filter = e.target.value.toLowerCase();
        const cards = document.querySelectorAll('.pokemon-card');
        cards.forEach(card => {
            const name = card.querySelector('h3').textContent.toLowerCase();
            if (name.includes(filter)) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });
    }); */
});
