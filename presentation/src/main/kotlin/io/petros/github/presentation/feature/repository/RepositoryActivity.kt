package io.petros.github.presentation.feature.repository

import android.os.Bundle
import com.f2prateek.dart.InjectExtra
import io.petros.github.R
import io.petros.github.domain.model.search.Repository
import io.petros.github.presentation.feature.BaseActivity
import kotlinx.android.synthetic.main.activity_repository.*

class RepositoryActivity : BaseActivity<RepositoryActivityViewModel>() {

    @InjectExtra lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        tv_repository.text = repository.name
    }

    private fun initToolbar() {
        toolbar.bind(repository)
        toolbar.setOnBackClick { onBackPressed() }
    }

    /* CONTRACT */

    override fun constructContentView() = R.layout.activity_repository

    override fun constructViewModel() = RepositoryActivityViewModel::class.java

}
