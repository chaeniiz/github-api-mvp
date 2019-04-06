package com.chaeniiz.domain.usecases

import com.chaeniiz.domain.repository.UserRepository
import com.chaeniiz.entity.entities.User
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetUserInfo(
    private val userRepository: UserRepository,
    executorScheduler: Scheduler = Schedulers.io(),
    postExecutionScheduler: Scheduler = AndroidSchedulers.mainThread()
) : SingleUseCase<User>(executorScheduler, postExecutionScheduler) {

    lateinit var userName: String

    override fun buildUseCaseSingle(): Single<User> =
        userRepository.getUserInfo(userName)
}
