package com.loc.newsapp.domain.usecases.news

data class NewsUseCase(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val getArticles: GetArticles,
    val getArticle: GetArticle,
    val selectArticle: SelectArticle,
    val selectArticles: SelectArticles
)