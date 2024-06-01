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
import com.cyberconnect.link3.DeleteWorkExperienceMutation
import com.cyberconnect.link3.type.DeleteWorkExperienceResponse_Status
import com.cyberconnect.link3.type.adapter.DeleteWorkExperienceResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object DeleteWorkExperienceMutation_ResponseAdapter {
  public object Data : Adapter<DeleteWorkExperienceMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("deleteWorkExperience")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        DeleteWorkExperienceMutation.Data {
      var _deleteWorkExperience: DeleteWorkExperienceMutation.DeleteWorkExperience? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _deleteWorkExperience = DeleteWorkExperience.obj().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return DeleteWorkExperienceMutation.Data(
        deleteWorkExperience = _deleteWorkExperience!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: DeleteWorkExperienceMutation.Data,
    ): Unit {
      writer.name("deleteWorkExperience")
      DeleteWorkExperience.obj().toJson(writer, customScalarAdapters, value.deleteWorkExperience)
    }
  }

  public object DeleteWorkExperience : Adapter<DeleteWorkExperienceMutation.DeleteWorkExperience> {
    public val RESPONSE_NAMES: List<String> = listOf("status")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        DeleteWorkExperienceMutation.DeleteWorkExperience {
      var _status: DeleteWorkExperienceResponse_Status? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = DeleteWorkExperienceResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return DeleteWorkExperienceMutation.DeleteWorkExperience(
        status = _status!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: DeleteWorkExperienceMutation.DeleteWorkExperience,
    ): Unit {
      writer.name("status")
      DeleteWorkExperienceResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters,
          value.status)
    }
  }
}