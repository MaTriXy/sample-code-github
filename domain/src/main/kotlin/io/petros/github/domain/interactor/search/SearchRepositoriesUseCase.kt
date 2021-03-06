package io.petros.github.domain.interactor.search

import io.petros.github.domain.interactor.UseCaseSingle
import io.petros.github.domain.model.repository.RepositoryResults
import io.petros.github.domain.reactive.rx.RxSchedulers
import io.petros.github.domain.repository.search.SearchRepository
import io.reactivex.Single
import javax.inject.Inject

class SearchRepositoriesUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
    rxSchedulers: RxSchedulers
) : UseCaseSingle<RepositoryResults, SearchRepositoriesUseCase.Params>(rxSchedulers) {

    override fun buildUseCaseObservable(params: Params): Single<RepositoryResults> {
        return searchRepository.searchRepositories(params.searchTerm)
    }

    data class Params constructor(val searchTerm: String) {

        companion object {

            fun with(searchTerm: String): Params {
                return Params(searchTerm)
            }

        }

    }

}
