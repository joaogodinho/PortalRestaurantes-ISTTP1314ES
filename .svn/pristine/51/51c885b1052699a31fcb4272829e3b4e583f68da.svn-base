package pt.ist.rest.mealcheck;

import java.util.List;

import pt.ist.rest.mealcheck.exception.CheckAlreadyUsedException;
import pt.ist.rest.mealcheck.exception.CheckNotExistsException;
import pt.ist.rest.mealcheck.exception.InvalidCheckException;
import pt.ist.rest.mealcheck.exception.InvalidCheckValueException;
import pt.ist.rest.mealcheck.exception.NotEndorsableCheckException;
import pt.ist.rest.mealcheck.exception.UserNotFoundException;

/**
 * The Interface MealCheckImplementor.
 */
public interface MealCheckImplementor {

    /**
     * Emitir.
     *
     * @param titular the titular
     * @param valor the valor
     * @param endossavel the endossavel
     * @return the string
     * @throws UserNotFoundException the user not found exception
     * @throws InvalidCheckValueException the invalid check value exception
     */
    String emitir(String titular, int valor, boolean endossavel) throws UserNotFoundException,
            InvalidCheckValueException;

    /**
     * Sacar.
     *
     * @param beneficiario the beneficiario
     * @param numeros the numeros
     * @return the int
     * @throws InvalidCheckException the invalid check exception
     * @throws CheckAlreadyUsedException the check already used exception
     * @throws CheckNotExistsException the check not exists exception
     * @throws UserNotFoundException the user not found exception
     */
    int sacar(String beneficiario, List<String> numeros) throws InvalidCheckException,
            CheckAlreadyUsedException,
            CheckNotExistsException,
            UserNotFoundException;

    /**
     * Endossar.
     *
     * @param titular the titular
     * @param terceiro the terceiro
     * @param numero the numero
     * @return the string
     * @throws CheckNotExistsException the check not exists exception
     * @throws CheckAlreadyUsedException the check already used exception
     * @throws NotEndorsableCheckException the not endorsable check exception
     * @throws UserNotFoundException the user not found exception
     */
    String endossar(String titular, String terceiro, String numero) throws CheckNotExistsException,
            CheckAlreadyUsedException,
            NotEndorsableCheckException,
            UserNotFoundException;

    /**
     * Listar.
     *
     * @param titular the titular
     * @param sacados the sacados
     * @return returns java.util.List<java.lang.String>
     * @throws UserNotFoundException the user not found exception
     */
    List<String> listar(String titular, boolean sacados) throws UserNotFoundException;
}
