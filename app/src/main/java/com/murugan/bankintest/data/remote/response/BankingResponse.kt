package com.murugan.bankintest.data.remote.response

data class BankingResponse(
    val pagination: Pagination,
    val resources: List<Resource>
)