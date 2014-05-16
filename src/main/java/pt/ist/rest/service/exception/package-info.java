/**
 * Exceptions for the Service layer.
 * 
 * The most abstract exception in this package is ServiceException from which all
 * exceptions extends, then we have PlateException, RestaurantException and UserException
 * and for last we have the remaining more specific exceptions that extends the 
 * previous ones.
 */
package pt.ist.rest.service.exception;