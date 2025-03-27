pragma solidity >0.5.0;

contract User {

    struct Person {
        uint ownerId;
        //for user set int value 1,
        //for registrar set int value 2,
        //for tahsildar set int value 3,
        //for superAdmin set int value 4.
        uint8 userType;
    }

    mapping(address => Person) users;
    
     //constructor
    constructor() public{
        users[msg.sender].userType=4;
    }
    
    
    //Add user
    
    //Checking user as role values
	modifier isUser(address _user) {
		require(users[_user].userType == 1);
		_;
	}
	modifier isRegistrar(address _registrar) {
		require(users[_registrar].userType == 2);
		_;
	}
	modifier isTahsildar(address _tahsildar) {
		require(users[_tahsildar].userType == 3);
		_;
	}
	modifier isSuperAdmin(address _superUser) {
		require(users[_superUser].userType == 4);
		_;
	}

    //Adding differnt Users
    function addUser (address _newUser,uint _ownerId) public returns(bool){
        //Check user id not present
        require(users[_newUser].userType == 0 && users[_newUser].ownerId==0);
        users[_newUser].ownerId=_ownerId;
        users[_newUser].userType=1;
        return true;
    }
    
    function addRegistrar (address _newUser,uint _ownerId) isSuperAdmin(msg.sender) public returns(bool){
        //Check user id not present
        require(users[_newUser].userType == 0 && users[_newUser].ownerId==0);
        users[_newUser].ownerId=_ownerId;
        users[_newUser].userType=2;
        return true;
    }
    
    function addTahsildar (address _newUser,uint _ownerId) isSuperAdmin(msg.sender) public returns(bool){
        //Check user id not present
        require(users[_newUser].userType == 0 && users[_newUser].ownerId==0);
        users[_newUser].ownerId=_ownerId;
        users[_newUser].userType=3;
        return true;
    }
    
    function addSuperUser (address _newUser,uint _ownerId) isSuperAdmin(msg.sender) public returns(bool){
        //Check user id not present
        require(users[_newUser].userType == 0 && users[_newUser].ownerId==0);
        users[_newUser].ownerId=_ownerId;
        users[_newUser].userType=4;
        return true;
    }
}
