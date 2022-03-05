package com.dakuinternational.common.domain.repository

import com.dakuinternational.common.domain.model.DataContent
import com.dakuinternational.common.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface DataRepo {
    fun getAllData() : Flow<Response<DataContent>>
}