package tk.tianyuge.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface SrmCommonMapper {

    /**
     * 根据物料类别id查询是否特殊物料
     * @param itemCategoryId
     * @return
     */
    @Select("SELECT sic.category_code IN (110301,110302,110303,110304,110305) " +
            "FROM smdm_item_category sic " +
            "WHERE sic.category_id = #{itemcategoryId}")
    int isSpecItemByItemCategoryId(Long itemCategoryId);

    /**
     * 查询物料扩展字段
     * @param itemId
     * @return
     */
    @Select("SELECT si.attribute_varchar2 FROM smdm_item si where si.item_id = #{itemId}")
    String selectSpecItemSpecByItemId(Long itemId);

    /**
     * 查询物料类别编码
     * @param itemCategoryId
     * @return
     */
    @Select("SELECT sic.category_code " +
            "FROM smdm_item_category sic " +
            "WHERE sic.category_id = #{itemcategoryId}")
    String selectCodeByItemCategoryId(Long itemCategoryId);

    /**
     * 根据物料id查询是否特殊物料
     * @param itemId
     * @return
     */
    @Select("SELECT sic.category_code IN (110301,110302,110303,110304,110305) " +
            "FROM smdm_item si " +
            "JOIN smdm_item_category_assign sica ON sica.item_id = si.item_id " +
            "JOIN smdm_item_category sic ON sic.category_id = sica.category_id " +
            "WHERE si.item_id = #{itemId}")
    int isSpecItemByItemId(Long itemId);

    /**
     * 通过采购组织id查询采购组织名称
     * @param purOrgId
     * @return
     */
    @Select("select hpo.organization_name from hpfm_purchase_organization hpo where hpo.enabled_flag = 1 and hpo.purchase_org_id = #{purOrgId}")
    String selectPurchaseOrgNameById(Long purOrgId);

    /**
     * 通过采购组织id查询采购组织编码
     * @param purOrgId
     * @return
     */
    @Select("select hpo.organization_code from hpfm_purchase_organization hpo where hpo.enabled_flag = 1 and hpo.purchase_org_id = #{purOrgId}")
    String selectPurchaseOrgCodeById(Long purOrgId);

    /**
     * 根据用户id查询用户所属部门
     * @param userId
     * @return
     */
    @Select("select hu.unit_name from hpfm_employee_assign hea " +
            "join hpfm_unit hu on hu.unit_id = hea.unit_id join hpfm_employee_user heu on heu.employee_id = hea.employee_id " +
            "where hea.primary_position_flag = 1 and heu.user_id = #{userId}")
    String selectBelongUnit(Long userId);

    /**
     * 根据协议编码查询是否框架协议
     * @param pcNum
     * @return
     */
    @Select("select if(sph.pc_kind_code = 'FRAMEWORK_AGREEMENT', 1, 0) " +
            "from spcm_pc_header sph where sph.pc_num = #{pcNum}")
    String selectPcIsFramework(String pcNum);

    /**
     * 根据付款条款查询条款名称
     * @param termId
     * @return
     */
    @Select("select term_name from smdm_payment_term where term_id = #{termId}")
    String selectPaymentTermName(Long termId);

    /**
     * 根据付款条款查询条款编码
     * @param termId
     * @return
     */
    @Select("select term_code from smdm_payment_term where term_id = #{termId}")
    String selectPaymentTermCode(Long termId);

    /**
     * 根据单位id查询单位名称
     * @param uomId
     * @return
     */
    @Select("select uom_name from smdm_uom where uom_id = #{uomId}")
    String selectUomNameById(Long uomId);

    /**
     * 根据单位id查询单位编码
     * @param uomId
     * @return
     */
    @Select("select uom_code from smdm_uom where uom_id = #{uomId}")
    String selectUomCodeById(Long uomId);

    /**
     * 根据库存组织id查询库存组织名称
     * @param orgId
     * @return
     */
    @Select("select hio.organization_name from hpfm_inv_organization hio where hio.organization_id = #{organizationId}")
    String selectInvOrgNameById(Long orgId);

    /**
     * 根据库存组织id查询库存组织编码
     * @param orgId
     * @return
     */
    @Select("select hio.organization_code from hpfm_inv_organization hio where hio.organization_id = #{organizationId}")
    String selectInvOrgCodeById(Long orgId);

    /**
     * 根据订单行Id查询价格库关联的来源单号
     * @param poLineId
     * @return
     */
    @Select("select price_source_num from sodr_po_line where po_line_id = #{poLineId}")
    String selectPoLinePriceSourceNum(Long poLineId);

    /**
     * 根据订单行Id查询价格库关联的来源单行号
     * @param poLineId
     * @return
     */
    @Select("select price_source_line_num from sodr_po_line where po_line_id = #{poLineId}")
    String selectPoLinePriceSourceLineNum(Long poLineId);
}
