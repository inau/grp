package groop.requests.user;

import groop.persistance.entities.eUser;
import groop.requests.PasswordRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class NewUserRequest {

	@NotNull
    @Valid
	private eUser user;
	
	@NotNull
	@Valid
	private PasswordRequest password;

    public NewUserRequest() {
    }

    public NewUserRequest(final eUser user, final PasswordRequest password) {
        this.user = user;
        this.password = password;
    }

    public eUser getUser() {
        return user;
    }

    public void setUser(eUser user) {
        this.user = user;
    }

    public PasswordRequest getPassword() {
        return password;
    }

    public void setPassword(PasswordRequest password) {
        this.password = password;
    }
	
}
