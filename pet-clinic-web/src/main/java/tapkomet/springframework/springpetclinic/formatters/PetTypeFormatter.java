package tapkomet.springframework.springpetclinic.formatters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import tapkomet.springframework.springpetclinic.model.PetType;
import tapkomet.springframework.springpetclinic.services.PetTypeService;

import java.util.Locale;

/**
 * Created by Tapkomet on 3/6/2020
 */

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) {
        return petTypeService.findByName(text);
    }

}