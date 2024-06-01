//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.PublishCommentMutation
import com.cyberconnect.link3.type.PublishPostCommentResponse_Status
import com.cyberconnect.link3.type.adapter.PublishPostCommentResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object PublishCommentMutation_ResponseAdapter {
  public object Data : Adapter<PublishCommentMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("publishComment")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        PublishCommentMutation.Data {
      var _publishComment: PublishCommentMutation.PublishComment? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _publishComment = PublishComment.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return PublishCommentMutation.Data(
        publishComment = _publishComment!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: PublishCommentMutation.Data,
    ): Unit {
      writer.name("publishComment")
      PublishComment.obj().toJson(writer, customScalarAdapters, value.publishComment)
    }
  }

  public object PublishComment : Adapter<PublishCommentMutation.PublishComment> {
    public val RESPONSE_NAMES: List<String> = listOf("status", "contentID")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        PublishCommentMutation.PublishComment {
      var _status: PublishPostCommentResponse_Status? = null
      var _contentID: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = PublishPostCommentResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          1 -> _contentID = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return PublishCommentMutation.PublishComment(
        status = _status!!,
        contentID = _contentID!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: PublishCommentMutation.PublishComment,
    ): Unit {
      writer.name("status")
      PublishPostCommentResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters,
          value.status)

      writer.name("contentID")
      StringAdapter.toJson(writer, customScalarAdapters, value.contentID)
    }
  }
}
