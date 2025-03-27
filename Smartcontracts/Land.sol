pragma solidity >0.4.0;
import './User.sol';
import './Transactions.sol';

contract LandContract is User,Transactions{

    struct landDetails{
        //Land Registry-Address Details
        uint surveyNumber;
        uint registrationNumber;
        uint registrationYear;
        uint mutationNumber;
        //land  
        string district;
        string areaOfLand;
        //Owner Details
        uint32 ownerId;
        //Values for cross checks
        bool taxPending;
        bool loanPending;
        bool pendingLitigation;
    }
    
    event landTransaction(uint32 fromId,uint32 toId,uint256 landId);
    
    mapping(uint256=>landDetails) landRecords;
    
     //Checking user as role values
	modifier isOwner(uint256 _landId,uint32 _user) {
		require(landRecords[_landId].ownerId == _user);
		_;
	}
	  
    //modifier for Transfer conditions
    modifier canTransfer(uint _landId){
        require((landRecords[_landId].taxPending==false) 
        && (landRecords[_landId].loanPending==false)
        && (landRecords[_landId].pendingLitigation==false));
        _;
    }
	
     // to compute id for a land.
    function computeId(string memory _state,string memory _district,string memory _village,uint _surveyNumber, uint _registrationNumber, uint _mutationNumber) public pure returns(uint){
        return uint(keccak256(abi.encodePacked(_state,_district,_village,_surveyNumber,_registrationNumber,_mutationNumber)))%10000000000000;
    }
    

    //add land Record
    function addLand(uint id, uint _surveyNumber, uint _registrationNumber, uint _registrationYear, uint _mutationNumber,
        uint32 _ownerId, string memory _district,
        string memory _areaOfLand, bool _taxPending, bool _loanPending, bool _pendingLitigation) isTahsildar(msg.sender) public returns(bool) {
       
        landRecords[id].surveyNumber=_surveyNumber;
        landRecords[id].registrationNumber=_registrationNumber;
        landRecords[id].registrationYear=_registrationYear;
        landRecords[id].mutationNumber=_mutationNumber;
        landRecords[id].ownerId=_ownerId;
        landRecords[id].district=_district;
        landRecords[id].areaOfLand=_areaOfLand;
        landRecords[id].taxPending=_taxPending;
        landRecords[id].loanPending=_loanPending;
        landRecords[id].pendingLitigation=_pendingLitigation;
        return(true);
    }

    //get Land Details
    function getland(uint256 _landId) public view returns( uint _surveyNumber, uint _registrationNumber, uint _registrationYear,
        uint _mutationNumber,uint32 _ownerId, string memory _district,string memory _areaOfLand, bool _taxPending, bool _loanPending, 
        bool _pendingLitigation){
        landDetails memory l= landRecords[_landId];
        return ( l.surveyNumber, l.registrationNumber, l.registrationYear, l.mutationNumber,l.ownerId, l.district,
        l.areaOfLand, l.taxPending, l.loanPending, l.pendingLitigation);
    }
    
    //set loan value 
    function setLoanValue(uint id,bool _loanPending) isTahsildar(msg.sender) public returns(bool){
        landRecords[id].loanPending=_loanPending;
        return(true);
    }
    
    //set Tax value 
    function setTaxValue(uint id,bool _taxPending) isTahsildar(msg.sender) public returns(bool){
        landRecords[id].taxPending=_taxPending;
        return(true);
    }
    
    //get Land ownerId
    function getOwner(uint256 _landId) public view returns(uint32){
        return(landRecords[_landId].ownerId);
    }
    
    //Complete Transfer
    function completeTransaction(uint256 _landId, uint32 _fromId ,uint32 _toId ,string memory _date)
            canTransfer(_landId) isRegistrar(msg.sender) public returns(bool){
        landRecords[_landId].ownerId=_toId;
        history[_landId].push(landHistory(_fromId,_toId,_date));
        emit landTransaction(_fromId,_toId,_landId);
        return(true);
    }
}