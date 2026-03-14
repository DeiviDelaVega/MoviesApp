package com.dev.moviesapp.domain.usecase.video

import com.dev.moviesapp.domain.model.Video
import com.dev.moviesapp.domain.repository.VideoRepository
import javax.inject.Inject

class GetMovieVideosUseCase @Inject constructor(
    private val videoRepository: VideoRepository
) {
    suspend operator fun invoke(movieId: Int): Result<Video?> =
        videoRepository.getMovieVideos(movieId).map { videos ->
            videos.firstOrNull {
                it.type == "Trailer" && it.site == "Youtube"
            }
        }
}