package pt.ist.rest.mealcheck;

import java.util.List;

import pt.ist.rest.mealcheck.exception.CheckAlreadyUsedException;
import pt.ist.rest.mealcheck.exception.CheckNotExistsException;
import pt.ist.rest.mealcheck.exception.InvalidCheckException;
import pt.ist.rest.mealcheck.exception.InvalidCheckValueException;
import pt.ist.rest.mealcheck.exception.NotEndorsableCheckException;
import pt.ist.rest.mealcheck.exception.UserNotFoundException;

/**
 * The Class MealCheckAbstraction.
 */
public class MealCheck {

    /**
     * The mealcheck.
     */
    private final MealCheckImplementor mealcheck;

    /**
     * Instantiates a new meal check.
     * 
     * @param mealcheck the mealcheck
     */
    public MealCheck(MealCheckImplementor mealcheck) {
        this.mealcheck = mealcheck;
    }

    /**
     * Sacar.
     * 
     * @param payee the payee
     * @param checks the checks
     * @return the int
     * @throws InvalidCheckException the invalid check exception
     * @throws CheckAlreadyUsedException the check already used exception
     * @throws CheckNotExistsException the check not exists exception
     * @throws UserNotFoundException the user not found exception
     */
    public int sacar(String payee, List<String> checks) throws InvalidCheckException,
            CheckAlreadyUsedException,
            CheckNotExistsException,
            UserNotFoundException {
        return mealcheck.sacar(payee, checks);
    }

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
    public String emitir(String titular, int valor, boolean endossavel) throws UserNotFoundException,
            InvalidCheckValueException {
        return mealcheck.emitir(titular, valor, endossavel);
    }

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
    public String endossar(String titular, String terceiro, String numero) throws CheckNotExistsException,
            CheckAlreadyUsedException,
            NotEndorsableCheckException,
            UserNotFoundException {
        return mealcheck.endossar(titular, terceiro, numero);
    }

    /**
     * Listar.
     * 
     * @param titular the titular
     * @param sacados the sacados
     * @return the list of Cheque's identifiers
     * @throws UserNotFoundException the user not found exception
     */
    public List<String> listar(String titular, boolean sacados) throws UserNotFoundException {
        return mealcheck.listar(titular, sacados);
    }
}
