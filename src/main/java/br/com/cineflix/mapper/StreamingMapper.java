package br.com.cineflix.mapper;

import java.util.Locale.Category;

import br.com.cineflix.controller.request.StreamingRequest;
import br.com.cineflix.controller.response.StreamingResponse;
import br.com.cineflix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass 
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest){
        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();

    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
}
}