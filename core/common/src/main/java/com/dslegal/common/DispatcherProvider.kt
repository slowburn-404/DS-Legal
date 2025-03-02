package com.dslegal.common

import kotlinx.coroutines.CoroutineDispatcher

/** This interface defines a contract for providing access to different
 * coroutine dispatchers, which are used to control the execution context
 * of coroutines
 */

interface DispatcherProvider {
    /** This coroutine dispatcher
     * for I/O bound operations
     */
    val ioDispatcher: CoroutineDispatcher
}