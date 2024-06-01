//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.DeleteRecommendationMutation
import com.cyberconnect.link3.type.DeleteRecommendationResponse_Status
import com.cyberconnect.link3.type.adapter.DeleteRecommendationResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object DeleteRecommendationMutation_ResponseAdapter {
  public object Data : Adapter<DeleteRecommendationMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("deleteRecommendation")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        DeleteRecommendationMutation.Data {
      var _deleteRecommendation: DeleteRecommendationMutation.DeleteRecommendation? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _deleteRecommendation = DeleteRecommendation.obj().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return DeleteRecommendationMutation.Data(
        deleteRecommendation = _deleteRecommendation!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: DeleteRecommendationMutation.Data,
    ): Unit {
      writer.name("deleteRecommendation")
      DeleteRecommendation.obj().toJson(writer, customScalarAdapters, value.deleteRecommendation)
    }
  }

  public object DeleteRecommendation : Adapter<DeleteRecommendationMutation.DeleteRecommendation> {
    public val RESPONSE_NAMES: List<String> = listOf("status")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        DeleteRecommendationMutation.DeleteRecommendation {
      var _status: DeleteRecommendationResponse_Status? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = DeleteRecommendationResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return DeleteRecommendationMutation.DeleteRecommendation(
        status = _status!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: DeleteRecommendationMutation.DeleteRecommendation,
    ): Unit {
      writer.name("status")
      DeleteRecommendationResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters,
          value.status)
    }
  }
}