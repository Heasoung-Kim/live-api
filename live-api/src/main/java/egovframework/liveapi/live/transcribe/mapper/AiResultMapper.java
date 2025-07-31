package egovframework.liveapi.live.transcribe.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import egovframework.liveapi.cmm.mapper.CommonMapperUtil;
import egovframework.liveapi.live.transcribe.domain.AiResult;
import egovframework.liveapi.live.transcribe.dto.AiResultDto;

@Mapper(componentModel = "spring",imports = ObjectId.class, uses = CommonMapperUtil.class)
public interface AiResultMapper {

    AiResultMapper INSTANCE = Mappers.getMapper(AiResultMapper.class);

    AiResultDto toDto(AiResult segment);

    AiResult toEntity(AiResultDto dto);
}
