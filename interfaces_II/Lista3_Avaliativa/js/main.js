$(function () {
  const products = [
    { name: 'Camiseta Titular', price: '399.90', category: 'Camisas' },
    { name: 'Camiseta Reserva', price: '399.90', category: 'Camisas' },
    { name: 'Calção Vermelho', price: '159.90', category: 'Calcoes' },
    { name: 'Calção Branco', price: '159.90', category: 'Calcoes' },
    { name: 'Casaco Corta Vento', price: '499.90', category: 'Casacos' },
    { name: 'Jaqueta', price: '799.90', category: 'Casacos' },
    { name: 'Camisa Três', price: '399.90', category: 'Camisas' },
    { name: 'Tênis', price: '299.90', category: 'Outros' }
  ];

  function renderProducts() {
    const container = $('#lista-produtos');
    if (!container.length) return;
    container.empty();
    products.forEach(p => {
      const card = $("<div>").addClass('produto').attr('data-name', p.name).attr('data-price', p.price);
      card.append(`<div class="corpo-produto"><h3 class="nome-produto">${p.name}</h3><p class="prod-cat">${p.category}</p><p class="preco">R$ ${p.price}</p></div>`);
      card.append(`<div class="acoes-produto"><button class="ver-produto">Ver produto</button></div>`);
      container.append(card);
    });
  }

  function renderMenu() {
    const menu = $('#menu');
    if (!menu.length) return;
    menu.empty();

    menu.append('<li><a href="#">Início</a></li>');

    const byCat = {};
    products.forEach(p => {
      const cat = p.category || 'Outros';
      if (!byCat[cat]) byCat[cat] = [];
      byCat[cat].push(p);
    });

    const categoriasLi = $('<li>').addClass('has-sub').append($('<a href="#">').text('Categorias'));
    const categoriasUl = $('<ul>');
    Object.keys(byCat).forEach(cat => {
      const catLi = $('<li>').addClass('has-sub').append($('<a href="#">').text(cat));
      const catUl = $('<ul>');
      byCat[cat].forEach(p => {
        const item = $(`<li><a href="#" class="link-produto" data-name="${p.name}" data-price="${p.price}">${p.name}</a></li>`);
        catUl.append(item);
      });
      catLi.append(catUl);
      categoriasUl.append(catLi);
    });
    categoriasLi.append(categoriasUl);
    menu.append(categoriasLi);

  }

  renderProducts();
  renderMenu();

  $("#dialogo-boasvindas").dialog({
    modal: true,
    buttons: {
      "Fechar": function () {
        $(this).dialog("close");
      }
    }
  });

  $("#abas").tabs();

  const hoje = new Date();
  const primeiroDia = new Date(hoje.getFullYear(), hoje.getMonth(), 1);
  const ultimoDia = new Date(hoje.getFullYear(), hoje.getMonth() + 1, 0);

  $("#calendario").datepicker({
    dateFormat: 'dd/mm/yy',
    minDate: primeiroDia,
    maxDate: ultimoDia,
    changeMonth: false,
    changeYear: false,
    showAnim: 'fadeIn'
  });

  $(document).on('click', '.ver-produto', function () {
    const container = $(this).closest('.produto');
    const nome = container.data('name');
    const preco = container.data('price');
    $("#info-produto").html(`<strong>${nome}</strong><br>Preço: R$ ${preco}`);
    $("#dialogo-produto").dialog({
      modal: true,
      width: 350,
      buttons: {
        'Fechar': function () {
          $(this).dialog('close');
        }
      }
    });
  });

  if ($('#menu').length) {
    $('#menu').menu();

    $(document).on('click', '#menu li.has-sub > a', function (e) {
      e.preventDefault();
      e.stopPropagation();
      const li = $(this).parent();
      if (li.hasClass('open')) {
        li.removeClass('open');
        li.find('.open').removeClass('open');
      } else {
        li.siblings('.open').removeClass('open').find('.open').removeClass('open');
        li.addClass('open');
      }
    });

    $(document).on('click', '.link-produto', function(e){
      e.preventDefault();
      const nome = $(this).data('name');
      const preco = $(this).data('price');
      $('#info-produto').html(`<strong>${nome}</strong><br>Preço: R$ ${preco}`);
      $('#dialogo-produto').dialog({
        modal:true,
        width:380,
        buttons:{
          'Fechar': function(){ $(this).dialog('close'); }
        }
      });
    });

    $(document).on('click', '#open-contact-form', function (e) {
      e.preventDefault();
      $('#dialogo-contato').dialog({
        modal: true,
        width: 420,
        buttons: { 'Fechar': function () { $(this).dialog('close'); } }
      });
    });
  }

  $("#formulario-contato").on('submit', function (e) {
    e.preventDefault();
    const nome = $("#nome-contato").val();
    const email = $("#email-contato").val();
    const msg = $("#mensagem-contato").val();
    const data = $("#calendario").val() || 'Não agendado';

    const html = `<p><strong>Nome:</strong> ${nome}</p>
                  <p><strong>E-mail:</strong> ${email}</p>
                  <p><strong>Mensagem:</strong> ${msg}</p>
                  <p><strong>Data agendada:</strong> ${data}</p>`;
    $("#resumo-contato").html(html);
    $("#dialogo-contato").dialog({
      modal: true,
      width: 420,
      buttons: {
        'Fechar': function () { $(this).dialog('close'); }
      }
    });
  });
});
