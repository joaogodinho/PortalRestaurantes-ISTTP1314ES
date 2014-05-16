package pt.ist.chequerefeicao.local;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pt.ist.rest.mealcheck.MealCheckImplementor;
import pt.ist.rest.mealcheck.exception.CheckAlreadyUsedException;
import pt.ist.rest.mealcheck.exception.InvalidCheckException;

/**
 * This class represents a simplified local version of the external service
 * ChequeRefeicao. Each check is represented by a string. The simplifications made are the
 * following ones: - The data concerning the service ChequeRefeicao is not persistent - It
 * just support the operation of cashing checks. - In order to be able to simulate valid
 * and invalid checks, a valid check has an identifier that ends with a digit. - The
 * amount of a check is equal to 10 times the last digit of the identifier of the check.
 * 
 * @author ES
 **/
public class ChequeRefeicaoLocal
        implements MealCheckImplementor {

    /** The cashed. */
    private Set<String> cashed;

    /**
     * Instantiates a new cheque refeicao local.
     */
    public ChequeRefeicaoLocal() {
        this.cashed = new HashSet<String>();
    }

    /**
     * Cash a list of checks. A check can only be cashed once. Returns the amount of money
     * represented by all checks. The checks are cashed only if all of them are valid.
     * 
     * @param payee the recipient of the money
     * @param checks the list of checks to register
     * @return the amount of money represented by the list of checks to cash.
     * @throws InvalidCheckException if there is at least one check that is not a valid
     *             one.
     * @throws CheckAlreadyUsedException if there is at least one check that was
     *             registered previously.
     */
    @Override
    public int sacar(String payee, List<String> checks) throws InvalidCheckException,
            CheckAlreadyUsedException {
        int amount = 0;
        char lastChar;

        for (String check : checks) {
            if (cashed.contains(check))
                throw new CheckAlreadyUsedException(check);

            lastChar = check.charAt(check.length() - 1); // last character

            if (lastChar < '0' || lastChar > '9')
                throw new InvalidCheckException(check);

            final int multiplier = 10;
            amount += (lastChar - '0') * multiplier;
        }

        cashed.addAll(checks);
        return amount;
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.mealcheck.MealCheckImplementor#emitir(java.lang.String, int, boolean)
     */
    @Override
    public String emitir(String titular, int valor, boolean endossavel) {
        return null;
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.mealcheck.MealCheckImplementor#endossar(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String endossar(String titular, String terceiro, String numero) {
        return null;
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.mealcheck.MealCheckImplementor#listar(java.lang.String, boolean)
     */
    @Override
    public List<String> listar(String titular, boolean sacados) {
        return null;
    }
}
