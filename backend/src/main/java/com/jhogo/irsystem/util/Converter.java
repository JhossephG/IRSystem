package com.jhogo.irsystem.util;

public interface Converter <Model, ModelDTO> {
        Model convertToModel (ModelDTO dto);
        ModelDTO convertToDTO (Model model);
}
