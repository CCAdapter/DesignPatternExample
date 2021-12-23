package xmlMakeTest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "request")
@XmlType(name="",propOrder={})
public class RequetsXml {

    @XmlElement(name = "casefile")
    private CaseFile caseFile;

    @XmlElement(name = "uploaded-file-id")
    private String fileId;


    public void setCaseFile(CaseFile caseFile) {
        this.caseFile = caseFile;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    private static class CaseFile {

        private String name;

        @XmlElement(name = "isTmpFile")
        private boolean isTmpFile;

        @XmlElement(name = "modify-timestamp")
        private String modifyTimStamp;

        @XmlElement(name = "sdb-group-id")
        private Integer groupId;

        @XmlElement(name = "source-system-id")
        private Integer sourceId;


        public void setName(String name) {
            this.name = name;
        }


        public void setTmpFile(boolean tmpFile) {
            isTmpFile = tmpFile;
        }


        public void setModifyTimStamp(String modifyTimStamp) {
            this.modifyTimStamp = modifyTimStamp;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public void setSourceId(Integer sourceId) {
            this.sourceId = sourceId;
        }
    }

    public static void main(String[] args) throws JAXBException {
        RequetsXml root = new RequetsXml();
        root.setFileId("adsa45475454");

        CaseFile caseFile = new CaseFile();
        caseFile.setName("王凯");
        caseFile.setTmpFile(false);
        caseFile.setGroupId(1);
        caseFile.setSourceId(0);
        caseFile.setModifyTimStamp("1575454212");
        root.setCaseFile(caseFile);

        JAXBContext context = JAXBContext.newInstance(RequetsXml.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(root, System.out);

    }

}