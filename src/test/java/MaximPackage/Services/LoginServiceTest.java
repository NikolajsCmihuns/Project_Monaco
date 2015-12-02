package MaximPackage.Services;

import javax.servlet.http.HttpSession;

/**
 * Created by maksimspuskels on 30/10/15.
 */
public class LoginServiceTest {

    private UserDAOInterface userDao;
    private HttpSession sessionService;

   /* @Before
    public void setUp() throws DBException {
        userDao = mock(UserDAOInterface.class);
        sessionService = mock(HttpSession.class);
        User user = new User("masha", "email", 1, 2, "123");
        user.setUserID(1);
        expect(userDao.getUserByNickname("masha")).andReturn(user);
        expect(userDao.getUserByNickname("masha")).andReturn(user);
        expectLastCall();
        replay(userDao);
        replay(sessionService);
    }*/

   /* @Test
    public void testTryLogin() throws Exception {
        LoginService loginService = new LoginService(userDao);
        assertEquals(Integer.valueOf(1),loginService.tryLogin("masha","123"));
        assertEquals(User.NO_USER_FOUND, loginService.tryLogin("masha", "1234"));
    }

    @Test
    public void emptyTryLogin() throws Exception {
        LoginService loginService = new LoginService(userDao);
        assertEquals(User.NO_USER_FOUND, loginService.tryLogin("", ""));
    }*/
}