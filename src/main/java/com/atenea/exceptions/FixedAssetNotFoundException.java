package com.atenea.exceptions;

public class FixedAssetNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    private final Long id;

    public FixedAssetNotFoundException(Long id) {
        super("Lamentamos informar que no hemos podido localizar el activo con el ID proporcionado. Por favor, verifique si el ID es correcto y vuelva a intentarlo: " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
