package ru.skillbranch.devintensive.viewmodels

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.skillbranch.devintensive.models.Profile
import ru.skillbranch.devintensive.repositories.PreferencesRepository

class ProfileViewModel : ViewModel() {
    private val repository: PreferencesRepository = PreferencesRepository
    private val profileData = MutableLiveData<Profile>()
    private val appTheme = MutableLiveData<Int>()
    private val repositoryError = MutableLiveData<Boolean>()
    private val isRepoError = MutableLiveData<Boolean>()

    init {
        Log.d("M_ProfileViewModel", "init view model")
        profileData.value = repository.getProfile()
        appTheme.value = repository.getAppTheme()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("M_ProfileViewModel", "view model cleared")
    }

    fun getProfileData(): LiveData<Profile> = profileData

    fun getTheme(): LiveData<Int> = appTheme

    fun getRepositoryError(): LiveData<Boolean> = repositoryError

    fun getIsRepoError(): LiveData<Boolean> = isRepoError

    fun saveProfileData(profile: Profile) {
        repository.saveProfile(profile)
        profileData.value = profile
    }

    fun switchTheme() {
        appTheme.value = when (appTheme.value == AppCompatDelegate.MODE_NIGHT_YES) {
            true -> AppCompatDelegate.MODE_NIGHT_NO
            else -> AppCompatDelegate.MODE_NIGHT_YES
        }
        repository.saveAppTheme(appTheme.value!!)
    }

    fun onRepositoryChanged(repository: String) {
        repositoryError.value = isValidateRepository(repository)
    }

    fun onRepoEditCompleted(isError: Boolean) {
        isRepoError.value = isError
    }

    private fun isValidateRepository(repo: String) =
        if (repo.isBlank() || repo.isEmpty()) {
            false
        } else {
            val template = """^(?:https://)?(?:www\.)?github\.com/([a-zA-Z][a-zA-Z0-9]*-?[a-zA-Z0-9]+)/?$""".toRegex()
            val matchResult = template.find(repo)
            val repoName = matchResult?.groups?.get(1)?.value ?: ""
            !(repoName.isNotEmpty() && isExluded(repoName))
        }

    private fun isExluded(repo: String) =
        repo.trim().toLowerCase() !in listOf(
            "enterprise", "features", "topics", "collections", "trending", "events", "marketplace", "pricing",
            "nonprofit", "customer-stories", "security", "login", "join"
        )

}