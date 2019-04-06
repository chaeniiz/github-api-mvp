package com.chaeniiz.domain.usecases

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

abstract class SingleUseCase<T>(
    private val executorScheduler: Scheduler,
    private val postExecutionScheduler: Scheduler
) {

    private var disposable: CompositeDisposable = CompositeDisposable()

    protected abstract fun buildUseCaseSingle(): Single<T>

    fun execute(useCaseObserver: DisposableSingleObserver<T>) {
        if (!disposable.isDisposed) {
            disposable.add(
                buildUseCaseSingle()
                    .subscribeOn(executorScheduler)
                    .observeOn(postExecutionScheduler)
                    .subscribeWith(useCaseObserver)
            )
        }
    }

    fun get() = buildUseCaseSingle().subscribeOn(executorScheduler)
        .observeOn(postExecutionScheduler)

    fun clear() {
        disposable.clear()
    }

    fun dispose() {
        disposable.dispose()
    }
}
