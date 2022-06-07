window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Nota = window.blockly.js.blockly.Nota || {};

/**
 * @function criarBancoLocal
 *
 * Nota
 *
 *
 * @author Ícaro Da Silva Antunes
 * @since 02/06/2022 08:40:33
 *
 */
window.blockly.js.blockly.Nota.criarBancoLocalArgs = [];
window.blockly.js.blockly.Nota.criarBancoLocal = async function() {
 var item;
  //
  this.cronapi.screen.createScopeVariable('listaNotas', []);
  return this.cronapi.pouchdb.createLocalDatabase('notas', 'idb');
}

/**
 * @function alimentarListaDoEscopo
 *
 * Descreva esta função...
 *
 * @param lista
 *
 * @author Ícaro Da Silva Antunes
 * @since 02/06/2022 08:40:33
 *
 */
window.blockly.js.blockly.Nota.alimentarListaDoEscopoArgs = [{ description: 'lista', id: 'd5498fbb' }];
window.blockly.js.blockly.Nota.alimentarListaDoEscopo = async function(lista) {

  //
  this.cronapi.screen.changeValueOfField('listaNotas', []);
  //
  for (var i_index in lista) {
    i = lista[i_index];
    //
    this.cronapi.screen.getScopeVariable('listaNotas').push(this.cronapi.json.getProperty(i, 'doc'));
  }
  //
  this.cronapi.screen.changeValueOfField("vars.conteudo", null);
}

/**
 * @function excluirNotaBancoLocal
 *
 * Descreva esta função...
 *
 * @param nota
 *
 * @author Ícaro Da Silva Antunes
 * @since 02/06/2022 08:40:33
 *
 */
window.blockly.js.blockly.Nota.excluirNotaBancoLocalArgs = [{ description: 'nota', id: '935e7984' }];
window.blockly.js.blockly.Nota.excluirNotaBancoLocal = async function(nota) {

  //
  this.cronapi.json.setProperty(nota, 'exclusao', true);
  //
  this.cronapi.pouchdb.updateDoc((await this.blockly.js.blockly.Nota.criarBancoLocal()), nota, null, async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.notify('error','Erro ao excluir nota');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    //
    (await this.blockly.js.blockly.Nota.obterAnotacoesDoBancoLocal());
  }.bind(this));
}

/**
 * @function InserirNotaBancoLocal
 *
 * Descreva esta função...
 *
 * @param conteudo
 *
 * @author Ícaro Da Silva Antunes
 * @since 02/06/2022 08:40:33
 *
 */
window.blockly.js.blockly.Nota.InserirNotaBancoLocalArgs = [{ description: 'conteudo', id: '60242e28' }];
window.blockly.js.blockly.Nota.InserirNotaBancoLocal = async function(conteudo) {

  //
  nota = this.cronapi.object.newObject({name: 'conteudo', value: conteudo});
  //
  this.cronapi.pouchdb.createDoc((await this.blockly.js.blockly.Nota.criarBancoLocal()), nota, null, async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.notify('error','Erro ao inserir nota');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    //
    (await this.blockly.js.blockly.Nota.obterAnotacoesDoBancoLocal());
  }.bind(this));
  //
  this.cronapi.screen.changeValueOfField("vars.conteudo", null);
}

/**
 * @function SincroniaBancoRemotoParaBancoLocal
 *
 * Descreva esta função...
 *
 *
 * @author Ícaro Da Silva Antunes
 * @since 02/06/2022 08:40:33
 *
 */
window.blockly.js.blockly.Nota.SincroniaBancoRemotoParaBancoLocalArgs = [];
window.blockly.js.blockly.Nota.SincroniaBancoRemotoParaBancoLocal = async function() {
 var item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Notas:listarNotas', async function(sender_notas) {
      notas = sender_notas;
    //
    this.cronapi.pouchdb.createDocLote((await this.blockly.js.blockly.Nota.criarBancoLocal()), notas, null, async function(sender_item) {
        item = sender_item;
      //
      this.cronapi.screen.notify('error','Erro ao sincronizar banco local');
    }.bind(this), async function(sender_item) {
        item = sender_item;
      //
      (await this.blockly.js.blockly.Nota.obterAnotacoesDoBancoLocal());
    }.bind(this));
  }.bind(this));
}

/**
 * @function obterAnotacoesDoBancoLocal
 *
 * Descreva esta função...
 *
 *
 * @author Ícaro Da Silva Antunes
 * @since 02/06/2022 08:40:33
 *
 */
window.blockly.js.blockly.Nota.obterAnotacoesDoBancoLocalArgs = [];
window.blockly.js.blockly.Nota.obterAnotacoesDoBancoLocal = async function() {
 var item;
  //
  this.cronapi.pouchdb.getAllDoc((await this.blockly.js.blockly.Nota.criarBancoLocal()), this.cronapi.json.createObjectFromString('{\"include_docs\":true}'), async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.notify('error','Erro ao obter notas');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    //
    (await this.blockly.js.blockly.Nota.alimentarListaDoEscopo(this.cronapi.json.getProperty(item, 'rows')));
  }.bind(this));
}

/**
 * @function deletarNotasBancoLocal
 *
 * Descreva esta função...
 *
 * @param banco
 *
 * @author Ícaro Da Silva Antunes
 * @since 02/06/2022 08:40:33
 *
 */
window.blockly.js.blockly.Nota.deletarNotasBancoLocalArgs = [{ description: 'banco', id: 'f4afd555' }];
window.blockly.js.blockly.Nota.deletarNotasBancoLocal = async function(banco) {

  //
  this.cronapi.pouchdb.getAllDoc(banco, this.cronapi.json.createObjectFromString('{\"include_docs\":true}'), async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.notify('error','Erro ao obter as niotas');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    //
    var nota_list = this.cronapi.json.getProperty(item, 'rows');
    for (var nota_index in nota_list) {
      nota = nota_list[nota_index];
      //
      this.cronapi.pouchdb.deleteByIdDoc(banco, this.cronapi.json.getProperty(nota, 'id'), this.cronapi.json.getProperty(nota, 'value.rev'), null, async function(sender_item) {
          item = sender_item;
        //
        this.cronapi.screen.notify('error','Erro ao obter as niotas');
      }.bind(this), async function(sender_item) {
          item = sender_item;
      }.bind(this));
    }
  }.bind(this));
}

/**
 * @function inicializar
 *
 * Descreva esta função...
 *
 *
 * @author Ícaro Da Silva Antunes
 * @since 02/06/2022 08:40:33
 *
 */
window.blockly.js.blockly.Nota.inicializarArgs = [];
window.blockly.js.blockly.Nota.inicializar = async function() {
 var item;
  //
  this.cronapi.screen.createScopeVariable('listaNotas', []);
  //
  (await this.blockly.js.blockly.Nota.SincroniaBancoLocalParaBancoRemoto());
}

/**
 * @function SincroniaBancoLocalParaBancoRemoto
 *
 * Descreva esta função...
 *
 *
 * @author Ícaro Da Silva Antunes
 * @since 02/06/2022 08:40:33
 *
 */
window.blockly.js.blockly.Nota.SincroniaBancoLocalParaBancoRemotoArgs = [];
window.blockly.js.blockly.Nota.SincroniaBancoLocalParaBancoRemoto = async function() {
 var item;
  //
  this.cronapi.pouchdb.getAllDoc((await this.blockly.js.blockly.Nota.criarBancoLocal()), this.cronapi.json.createObjectFromString('{\"include_docs\":true}'), async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.notify('error','Erro ao sincronizzar o banco remoto');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    //
    (await this.blockly.js.blockly.Nota.alimentarListaDoEscopo(this.cronapi.json.getProperty(item, 'rows')));
    //
    (await this.cronapi.server('blockly.Notas.Gerenciar').names('cc09f569').toPromise().run(this.cronapi.screen.getScopeVariable('listaNotas')));
    //
    (await this.blockly.js.blockly.Nota.deletarNotasBancoLocal((await this.blockly.js.blockly.Nota.criarBancoLocal())));
    //
    (await this.blockly.js.blockly.Nota.SincroniaBancoRemotoParaBancoLocal());
  }.bind(this));
}
