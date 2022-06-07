package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Notas {

public static final int TIMEOUT = 300;

/**
 *
 * @param listaNotas
 *
 * @author Ícaro Da Silva Antunes
 * @since 01/06/2022 21:18:21
 *
 */
public static Var Gerenciar(@ParamMetaData(description = "listaNotas", id = "cc09f569") Var listaNotas) throws Exception {
 return new Callable<Var>() {

   private Var nota = Var.VAR_NULL;
   private Var contemId = Var.VAR_NULL;
   private Var contemExcluir = Var.VAR_NULL;

   public Var call() throws Exception {
    for (Iterator it_nota =
    cronapi.json.Operations.toJson(listaNotas).iterator(); it_nota.hasNext();) {
        nota = Var.valueOf(it_nota.next());
        contemId =
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.json.Operations.getJsonOrMapField(nota,
        Var.valueOf("id")));
        contemExcluir =
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.json.Operations.getJsonOrMapField(nota,
        Var.valueOf("exclusao")));
        if (
        Var.valueOf(contemId.getObjectAsBoolean() && contemExcluir.getObjectAsBoolean()).getObjectAsBoolean()) {
            cronapi.database.Operations.insert(Var.valueOf("app.entity.Nota"),Var.valueOf("conteudo",
            cronapi.json.Operations.getJsonOrMapField(nota,
            Var.valueOf("conteudo"))),Var.valueOf("user",
            cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:obterIddoUsuario"))));
        } else if (
        Var.valueOf(contemId
        .negate().getObjectAsBoolean() && contemExcluir
        .negate().getObjectAsBoolean()).getObjectAsBoolean()) {
            cronapi.database.Operations.remove(Var.valueOf("app.entity.Nota"),nota);
        }
    } // end for
    return
cronapi.list.Operations.newList();
   }
 }.call();
}

/**
 *
 * Notas
 *
 * @author Ícaro Da Silva Antunes
 * @since 01/06/2022 21:18:21
 *
 */
public static Var listarNotas() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;

   public Var call() throws Exception {
    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Nota"),Var.valueOf("select n from Nota n where n.user.id = :userId"),Var.valueOf("userId",
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:obterIddoUsuario"))));
    return lista;
   }
 }.call();
}

}

