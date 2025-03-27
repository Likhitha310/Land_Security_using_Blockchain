package com.mit.project.model.blockchain;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple10;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.3.0.
 */
public class LandContract extends Contract {
    private static final String BINARY = "60806040908152336000908152602081905220600101805460ff191660041790556114438061002f6000396000f3fe608060405234801561001057600080fd5b50600436106100cf5760003560e01c8063950ccc7c1161008c578063c41a360a11610066578063c41a360a146105c4578063d3017193146105fa578063d999347914610626578063de7111ca146106e7576100cf565b8063950ccc7c1461028157806396f4eeb0146103e6578063afaac2ca1461059f576100cf565b80634b5ee384146100d45780635b3f0fc114610103578063667a78601461013c5780636fe90055146101fd57806384cd1ec3146102295780638c9d677e14610255575b600080fd5b6100f1600480360360208110156100ea57600080fd5b5035610832565b60408051918252519081900360200190f35b6101286004803603604081101561011957600080fd5b50803590602001351515610844565b604080519115158252519081900360200190f35b61015f6004803603604081101561015257600080fd5b50803590602001356108a0565b604051808463ffffffff1663ffffffff1681526020018363ffffffff1663ffffffff16815260200180602001828103825283818151815260200191508051906020019080838360005b838110156101c05781810151838201526020016101a8565b50505050905090810190601f1680156101ed5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b6101286004803603604081101561021357600080fd5b506001600160a01b0381351690602001356109f9565b6101286004803603604081101561023f57600080fd5b506001600160a01b038135169060200135610a9d565b6101286004803603604081101561026b57600080fd5b506001600160a01b038135169060200135610b41565b610128600480360361016081101561029857600080fd5b81359160208101359160408201359160608101359160808201359163ffffffff60a0820135169181019060e0810160c0820135600160201b8111156102dc57600080fd5b8201836020820111156102ee57600080fd5b803590602001918460018302840111600160201b8311171561030f57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561036157600080fd5b82018360208201111561037357600080fd5b803590602001918460018302840111600160201b8311171561039457600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505050508035151591506020810135151590604001351515610be5565b6100f1600480360360c08110156103fc57600080fd5b810190602081018135600160201b81111561041657600080fd5b82018360208201111561042857600080fd5b803590602001918460018302840111600160201b8311171561044957600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561049b57600080fd5b8201836020820111156104ad57600080fd5b803590602001918460018302840111600160201b831117156104ce57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561052057600080fd5b82018360208201111561053257600080fd5b803590602001918460018302840111600160201b8311171561055357600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505082359350505060208101359060400135610cf3565b610128600480360360408110156105b557600080fd5b50803590602001351515610e23565b6105e1600480360360208110156105da57600080fd5b5035610e7c565b6040805163ffffffff9092168252519081900360200190f35b6101286004803603604081101561061057600080fd5b506001600160a01b038135169060200135610e97565b6101286004803603608081101561063c57600080fd5b81359163ffffffff602082013581169260408301359091169190810190608081016060820135600160201b81111561067357600080fd5b82018360208201111561068557600080fd5b803590602001918460018302840111600160201b831117156106a657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610f12945050505050565b610704600480360360208110156106fd57600080fd5b50356110aa565b604051808b81526020018a81526020018981526020018881526020018763ffffffff1663ffffffff1681526020018060200180602001861515151581526020018515151515815260200184151515158152602001838103835288818151815260200191508051906020019080838360005b8381101561078d578181015183820152602001610775565b50505050905090810190601f1680156107ba5780820380516001836020036101000a031916815260200191505b50838103825287518152875160209182019189019080838360005b838110156107ed5781810151838201526020016107d5565b50505050905090810190601f16801561081a5780820380516001836020036101000a031916815260200191505b509c5050505050505050505050505060405180910390f35b60009081526001602052604090205490565b3360008181526020819052604081206001015490919060ff1660031461086957600080fd5b60008481526002602052604090206006018054841515650100000000000265ff000000000019909116179055600191505092915050565b600080606060006001600087815260200190815260200160002085815481106108c557fe5b60009182526020808320600290920290910154888352600190915260408220805463ffffffff909216935090879081106108fb57fe5b906000526020600020906002020160000160049054906101000a900463ffffffff169050606060016000898152602001908152602001600020878154811061093f57fe5b90600052602060002090600202016001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109e45780601f106109b9576101008083540402835291602001916109e4565b820191906000526020600020905b8154815290600101906020018083116109c757829003601f168201915b50969c959b5092995093975050505050505050565b3360008181526020819052604081206001015490919060ff16600414610a1e57600080fd5b6001600160a01b03841660009081526020819052604090206001015460ff16158015610a6057506001600160a01b038416600090815260208190526040902054155b610a6957600080fd5b6001600160a01b03841660009081526020819052604090208381556001908101805460ff1916600317905591505092915050565b3360008181526020819052604081206001015490919060ff16600414610ac257600080fd5b6001600160a01b03841660009081526020819052604090206001015460ff16158015610b0457506001600160a01b038416600090815260208190526040902054155b610b0d57600080fd5b6001600160a01b03841660009081526020819052604090208381556001908101805460ff1916600417905591505092915050565b3360008181526020819052604081206001015490919060ff16600414610b6657600080fd5b6001600160a01b03841660009081526020819052604090206001015460ff16158015610ba857506001600160a01b038416600090815260208190526040902054155b610bb157600080fd5b6001600160a01b03841660009081526020819052604090208381556001908101805460ff1916600217905591505092915050565b3360008181526020819052604081206001015490919060ff16600314610c0a57600080fd5b60008d81526002602081815260409092208e8155600181018e90559081018c9055600381018b905560068101805463ffffffff191663ffffffff8c161790558851610c5d926004909201918a0190611314565b5060008d81526002602090815260409091208751610c8392600590920191890190611314565b50505060009a8b5260026020526040909a2060060180549a151566010000000000000266ff00000000000019921515650100000000000265ff000000000019941515600160201b0264ff0000000019909d169c909c17939093169a909a1716179097555060019695505050505050565b60006509184e72a0008787878787876040516020018087805190602001908083835b60208310610d345780518252601f199092019160209182019101610d15565b51815160209384036101000a600019018019909216911617905289519190930192890191508083835b60208310610d7c5780518252601f199092019160209182019101610d5d565b51815160209384036101000a600019018019909216911617905288519190930192880191508083835b60208310610dc45780518252601f199092019160209182019101610da5565b51815160209384036101000a600019018019909216911617905292019586525084810193909352506040808401919091528051808403820181526060909301905281519101209250839150610e17905057fe5b06979650505050505050565b3360008181526020819052604081206001015490919060ff16600314610e4857600080fd5b60008481526002602052604090206006018054841515600160201b0264ff0000000019909116179055600191505092915050565b60009081526002602052604090206006015463ffffffff1690565b6001600160a01b03821660009081526020819052604081206001015460ff16158015610ed957506001600160a01b038316600090815260208190526040902054155b610ee257600080fd5b506001600160a01b039190911660009081526020819052604090209081556001908101805460ff19168217905590565b6000848152600260205260408120600601548590600160201b900460ff16158015610f58575060008181526002602052604090206006015465010000000000900460ff16155b8015610f8057506000818152600260205260409020600601546601000000000000900460ff16155b610f8957600080fd5b3360008181526020819052604090206001015460ff16600214610fab57600080fd5b6000878152600260208181526040808420600601805463ffffffff808c1663ffffffff199283168117909355600180865284882085516060810187528f841681528088019586529586018d81528154808401808455928b529988902087519a909902909801805495518416600160201b0267ffffffff00000000199a90941695909416949094179790971617815593518051919592949361105193850192910190611314565b50506040805163ffffffff808b168252891660208201528082018b905290517f7129421a856987e940848950bd5341859b4067472843e19f98dc966b0b78d9259350908190036060019150a15060019695505050505050565b600080600080600060608060008060006110c2611392565b600260008d81526020019081526020016000206040518061014001604052908160008201548152602001600182015481526020016002820154815260200160038201548152602001600482018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156111a25780601f10611177576101008083540402835291602001916111a2565b820191906000526020600020905b81548152906001019060200180831161118557829003601f168201915b505050918352505060058201805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529382019392918301828280156112365780601f1061120b57610100808354040283529160200191611236565b820191906000526020600020905b81548152906001019060200180831161121957829003601f168201915b505050505081526020016006820160009054906101000a900463ffffffff1663ffffffff1663ffffffff1681526020016006820160049054906101000a900460ff161515151581526020016006820160059054906101000a900460ff161515151581526020016006820160069054906101000a900460ff161515151581525050905080600001518160200151826040015183606001518460c0015185608001518660a001518760e001518861010001518961012001518494508393509a509a509a509a509a509a509a509a509a509a50509193959799509193959799565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061135557805160ff1916838001178555611382565b82800160010185558215611382579182015b82811115611382578251825591602001919060010190611367565b5061138e9291506113f1565b5090565b604051806101400160405280600081526020016000815260200160008152602001600081526020016060815260200160608152602001600063ffffffff1681526020016000151581526020016000151581526020016000151581525090565b61140b91905b8082111561138e57600081556001016113f7565b9056fea265627a7a723058209a1f701673fcc75ecfd2f5cbfb3e3556870b50c46efbf921267eccf2f50a2b1f64736f6c63430005090032";

    public static final String FUNC_GETLENGTH = "getlength";

    public static final String FUNC_SETLOANVALUE = "setLoanValue";

    public static final String FUNC_GETTRANSACTIONHISTORYBYID = "getTransactionHistorybyId";

    public static final String FUNC_ADDTAHSILDAR = "addTahsildar";

    public static final String FUNC_ADDSUPERUSER = "addSuperUser";

    public static final String FUNC_ADDREGISTRAR = "addRegistrar";

    public static final String FUNC_ADDLAND = "addLand";

    public static final String FUNC_COMPUTEID = "computeId";

    public static final String FUNC_SETTAXVALUE = "setTaxValue";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_ADDUSER = "addUser";

    public static final String FUNC_COMPLETETRANSACTION = "completeTransaction";

    public static final String FUNC_GETLAND = "getland";

    public static final Event LANDTRANSACTION_EVENT = new Event("landTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected LandContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LandContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LandContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LandContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getlength(BigInteger _id) {
        final Function function = new Function(FUNC_GETLENGTH, 
                Arrays.<Type>asList(new Uint256(_id)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setLoanValue(BigInteger id, Boolean _loanPending) {
        final Function function = new Function(
                FUNC_SETLOANVALUE, 
                Arrays.<Type>asList(new Uint256(id),
                new Bool(_loanPending)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<BigInteger, BigInteger, String>> getTransactionHistorybyId(BigInteger _landId, BigInteger i) {
        final Function function = new Function(FUNC_GETTRANSACTIONHISTORYBYID, 
                Arrays.<Type>asList(new Uint256(_landId),
                new Uint256(i)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple3<BigInteger, BigInteger, String>>(
                new Callable<Tuple3<BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addTahsildar(String _newUser, BigInteger _ownerId) {
        final Function function = new Function(
                FUNC_ADDTAHSILDAR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newUser), 
                new Uint256(_ownerId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addSuperUser(String _newUser, BigInteger _ownerId) {
        final Function function = new Function(
                FUNC_ADDSUPERUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newUser), 
                new Uint256(_ownerId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addRegistrar(String _newUser, BigInteger _ownerId) {
        final Function function = new Function(
                FUNC_ADDREGISTRAR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newUser), 
                new Uint256(_ownerId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addLand(BigInteger id, BigInteger _surveyNumber, BigInteger _registrationNumber, BigInteger _registrationYear, BigInteger _mutationNumber, BigInteger _ownerId, String _district, String _areaOfLand, Boolean _taxPending, Boolean _loanPending, Boolean _pendingLitigation) {
        final Function function = new Function(
                FUNC_ADDLAND, 
                Arrays.<Type>asList(new Uint256(id),
                new Uint256(_surveyNumber),
                new Uint256(_registrationNumber),
                new Uint256(_registrationYear),
                new Uint256(_mutationNumber),
                new Uint32(_ownerId),
                new Utf8String(_district),
                new Utf8String(_areaOfLand),
                new Bool(_taxPending),
                new Bool(_loanPending),
                new Bool(_pendingLitigation)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> computeId(String _state, String _district, String _village, BigInteger _surveyNumber, BigInteger _registrationNumber, BigInteger _mutationNumber) {
        final Function function = new Function(FUNC_COMPUTEID, 
                Arrays.<Type>asList(new Utf8String(_state),
                new Utf8String(_district),
                new Utf8String(_village),
                new Uint256(_surveyNumber),
                new Uint256(_registrationNumber),
                new Uint256(_mutationNumber)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setTaxValue(BigInteger id, Boolean _taxPending) {
        final Function function = new Function(
                FUNC_SETTAXVALUE, 
                Arrays.<Type>asList(new Uint256(id),
                new Bool(_taxPending)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getOwner(BigInteger _landId) {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(new Uint256(_landId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addUser(String _newUser, BigInteger _ownerId) {
        final Function function = new Function(
                FUNC_ADDUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newUser), 
                new Uint256(_ownerId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> completeTransaction(BigInteger _landId, BigInteger _fromId, BigInteger _toId, String _date) {
        final Function function = new Function(
                FUNC_COMPLETETRANSACTION, 
                Arrays.<Type>asList(new Uint256(_landId),
                new Uint32(_fromId),
                new Uint32(_toId),
                new Utf8String(_date)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, Boolean, Boolean, Boolean>> getland(BigInteger _landId) {
        final Function function = new Function(FUNC_GETLAND, 
                Arrays.<Type>asList(new Uint256(_landId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, Boolean, Boolean, Boolean>>(
                new Callable<Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, Boolean, Boolean, Boolean>>() {
                    @Override
                    public Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, Boolean, Boolean, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, Boolean, Boolean, Boolean>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (Boolean) results.get(7).getValue(), 
                                (Boolean) results.get(8).getValue(), 
                                (Boolean) results.get(9).getValue());
                    }
                });
    }

    public List<LandTransactionEventResponse> getLandTransactionEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(LANDTRANSACTION_EVENT, transactionReceipt);
        ArrayList<LandTransactionEventResponse> responses = new ArrayList<LandTransactionEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            LandTransactionEventResponse typedResponse = new LandTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.fromId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.toId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.landId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LandTransactionEventResponse> landTransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LandTransactionEventResponse>() {
            @Override
            public LandTransactionEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(LANDTRANSACTION_EVENT, log);
                LandTransactionEventResponse typedResponse = new LandTransactionEventResponse();
                typedResponse.log = log;
                typedResponse.fromId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.toId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.landId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LandTransactionEventResponse> landTransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LANDTRANSACTION_EVENT));
        return landTransactionEventFlowable(filter);
    }

    @Deprecated
    public static LandContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LandContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LandContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LandContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LandContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LandContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LandContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LandContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LandContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LandContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LandContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LandContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<LandContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LandContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LandContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LandContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class LandTransactionEventResponse {
        public Log log;

        public BigInteger fromId;

        public BigInteger toId;

        public BigInteger landId;
    }
}
