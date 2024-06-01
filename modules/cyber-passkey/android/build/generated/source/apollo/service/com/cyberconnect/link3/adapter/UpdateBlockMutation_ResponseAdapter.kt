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
import com.cyberconnect.link3.UpdateBlockMutation
import com.cyberconnect.link3.type.UpdateBlockResponse_Status
import com.cyberconnect.link3.type.adapter.UpdateBlockResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object UpdateBlockMutation_ResponseAdapter {
  public object Data : Adapter<UpdateBlockMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("updateBlock")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UpdateBlockMutation.Data {
      var _updateBlock: UpdateBlockMutation.UpdateBlock? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _updateBlock = UpdateBlock.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UpdateBlockMutation.Data(
        updateBlock = _updateBlock!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UpdateBlockMutation.Data,
    ): Unit {
      writer.name("updateBlock")
      UpdateBlock.obj().toJson(writer, customScalarAdapters, value.updateBlock)
    }
  }

  public object UpdateBlock : Adapter<UpdateBlockMutation.UpdateBlock> {
    public val RESPONSE_NAMES: List<String> = listOf("status", "message")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UpdateBlockMutation.UpdateBlock {
      var _status: UpdateBlockResponse_Status? = null
      var _message: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = UpdateBlockResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          1 -> _message = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UpdateBlockMutation.UpdateBlock(
        status = _status!!,
        message = _message!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UpdateBlockMutation.UpdateBlock,
    ): Unit {
      writer.name("status")
      UpdateBlockResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)

      writer.name("message")
      StringAdapter.toJson(writer, customScalarAdapters, value.message)
    }
  }
}
